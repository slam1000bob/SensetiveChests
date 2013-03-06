package me.slam1000bob.SensitiveChests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Sign;
import org.bukkit.plugin.java.JavaPlugin;

public class SChests extends JavaPlugin implements Listener, CommandExecutor{
	private final Logger logger = Logger.getLogger("Minecraft");
	private List<ChestItem> items = new CopyOnWriteArrayList<ChestItem>();
	private List<Plate> plates = new CopyOnWriteArrayList<Plate>();
	private File configFile;
	private FileConfiguration config;
	private int chestRadius = 0;
	
	@Override
	public void onEnable(){
		configFile = new File(getDataFolder(), "config.yml");
		try {
			firstRun();
		} catch (Exception e) {e.printStackTrace();}
		config = new YamlConfiguration();
		loadYamls();
		
		loadPlates(config);
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runner(), 20L, 10L);
		getCommand("sc").setExecutor(this);
		logger.info("SensativeChests has been enabled!");
	}
	
	private void loadPlates(FileConfiguration config) {
		if(config.contains("Plates")){
			for(String s : config.getStringList("Plates")){
				String[] a = s.split(":");
				Location loc = new Location(getServer().getWorld(a[0]), Double.parseDouble(a[1]), Double.parseDouble(a[2]), Double.parseDouble(a[3]));
				plates.add(new Plate(loc.getBlock(), loc));
			}
		}else
			config.createSection("Plates");
		chestRadius = config.getInt("ChestRadius", 5);
	}
	
	private void writePlates(){
		List<String> configPlates = new ArrayList<String>();
		Location loc = null;
		String s = "";
		for(Plate plate : plates){
			loc = plate.getLocation();
			s = loc.getWorld().getName()+":"+loc.getX()+":"+loc.getY()+":"+loc.getZ();
			configPlates.add(s);
		}
		config.set("Plates", configPlates);
	}

	@Override
	public void onDisable(){
		writePlates();
		saveYamls();
		logger.info("SensativeChests has been disabled!");
	}
	
	private void firstRun() throws Exception {
	    if(!configFile.exists()){
	        configFile.getParentFile().mkdirs();
	        copy(getResource("config.yml"), configFile);
	    }
	}
	
	private void copy(InputStream in, File file) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void saveYamls() {
	    try {
	    	config.save(configFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadYamls() {
	    try {
	    	config.load(configFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean addItemToNearestChest(Item i){
		Block block = i.getLocation().getBlock();
		int rad = chestRadius*2+1;
		if(block.getType() != Material.WOOD_PLATE)
			for(BlockFace face : BlockFace.values())
				if(block.getRelative(face).getType() == Material.WOOD_PLATE){
					block = block.getRelative(face);
					break;
				}
		boolean isRegistered = false;
		for(Plate plate : plates)
			if(twoLocationsEqual(block.getLocation(), plate.getPlate().getLocation())){
				isRegistered = true;
				break;
			}
		if(!isRegistered)return false;
		Block checking = null;
		World world = block.getWorld();
		int X = block.getX()-chestRadius;
		int Y = block.getY()-chestRadius;
		int Z = block.getZ()-chestRadius;
		List<Chest> possChests = new CopyOnWriteArrayList<Chest>();
		if(block.getType() == Material.WOOD_PLATE){
			for(int x = 0; x<rad; x++){
				for(int y = 0; y<rad; y++){
					for(int z = 0; z<rad; z++){
						checking = new Location(world, X+x, Y+y, Z+z).getBlock();
						if(checking.getType() == Material.CHEST){
							Inventory inv = ((Chest) checking.getState()).getInventory();
							boolean hasEmptySlot = false;
							for (ItemStack stack : inv.getContents())
								if (stack == null) {
									hasEmptySlot = true;
									break;
								}
							ItemStack itemToAdd = i.getItemStack();
							int foundcount = itemToAdd.getAmount();
							for(ItemStack stack : inv.getContents()){
								if(stack == null) foundcount -= itemToAdd.getMaxStackSize();
								if(stack != null && stack.getType() == itemToAdd.getType()) {
									if(stack.getData().equals(itemToAdd.getData()))
										foundcount -= itemToAdd.getMaxStackSize() - stack.getAmount();
								}
							}
							boolean canContainitem = foundcount <= 0;
							if(hasEmptySlot || canContainitem)
								possChests.add((Chest)checking.getState());
						}
					}
				}
			}
			Chest chest = sort(i, possChests);
			if(chest != null){
				chest.getInventory().addItem(i.getItemStack());
				i.remove();
				return true;
			}
		}
		return false;
	}
	
	public Chest sort(Item i, List<Chest> chests){
		List<Category> cats = Categorizer.getCatagories(i);
		List<SChest> moreSChests = new ArrayList<SChest>();
		List<Block> sides = new ArrayList<Block>();
		ItemStack is = i.getItemStack();
		for(Chest chest : chests){
			sides.add(chest.getBlock().getRelative(BlockFace.NORTH));
			sides.add(chest.getBlock().getRelative(BlockFace.SOUTH));
			sides.add(chest.getBlock().getRelative(BlockFace.EAST));
			sides.add(chest.getBlock().getRelative(BlockFace.WEST));
			SChest sc = new SChest(chest);
			for(Block side : sides){
				if(side.getType() == Material.CHEST){
					sc.setAttached((Chest)side.getState());
				}
				if(side.getType() == Material.SIGN || side.getType() == Material.SIGN_POST || side.getType() == Material.WALL_SIGN){
					Sign sign = (Sign) side.getState().getData();
					Block attachedBlock = side.getRelative(sign.getAttachedFace());
					if(twoLocationsEqual(attachedBlock.getLocation(), chest.getLocation())){
						List<String> lines = new ArrayList<String>();
						org.bukkit.block.Sign sign2 = ((org.bukkit.block.Sign)side.getState());
						if(sign2.getLine(0).equalsIgnoreCase(ChatColor.AQUA+"[Sort]")){
							lines.add(sign2.getLine(1).toLowerCase());
							lines.add(sign2.getLine(2).toLowerCase());
							lines.add(sign2.getLine(3).toLowerCase());
							
							boolean canAdd = false;
							for(Category c : cats)
								if(lines.contains(c.getTheName()) || lines.contains(Category.MISC.getTheName())){
									sc.addCatagory(c);
									canAdd = true;
								}
							if(lines.contains(is.getTypeId()) || 
									(is.hasItemMeta() && lines.contains(is.getItemMeta().getDisplayName())) || 
									lines.contains(is.getType().toString().toLowerCase().replaceAll("_", " "))){
								return chest;
							}
								
							if(canAdd){
								moreSChests.add(sc);
								chests.remove(chest);
							}
						}
					}
				}
			}
			sides.clear();
		}
		Chest mostPriority = null;
		int priority = 1000;
		for(SChest sc : moreSChests)
			for(Category c : sc.getCatagories())
				if(c.getPriority()<priority)
					mostPriority = sc.getChest();
		if(mostPriority == null)
			if(chests.size() > 0 && chests.get(0) != null)
				return chests.get(0);
		return mostPriority;
	}
	
	public boolean twoLocationsEqual(Location l1, Location l2){
		if(l1.getWorld().getName().equals(l2.getWorld().getName()) && 
				Math.abs(Math.abs(l1.getX())-Math.abs(l2.getX()))<=1 && 
				Math.abs(Math.abs(l1.getY())-Math.abs(l2.getY()))<=1 && 
				Math.abs(Math.abs(l1.getZ())-Math.abs(l2.getZ()))<=1){
			return true;
		}
		return false;
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event){
		items.add(new ChestItem(event.getItemDrop(), event.getItemDrop().getLocation()));
	}
	
	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event){
		items.add(new ChestItem(event.getEntity(), event.getEntity().getLocation()));
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(event.getBlock().getType() == Material.WOOD_PLATE)
			for(Plate plate : plates)
				if(twoLocationsEqual(event.getBlock().getLocation(), plate.getPlate().getLocation()))
					plates.remove(plate);
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent event){
		if(event.getLine(0).equalsIgnoreCase("[Sort]"))
			event.setLine(0, ChatColor.AQUA+"[Sort]");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sc")){
			if(!(sender instanceof Player)){
				sender.sendMessage(ChatColor.DARK_RED+"You can't do this!");
				return true;
			}
			Player player = getServer().getPlayer(sender.getName());
			if(player.hasPermission("SensitiveChests.Register")){
				if(args.length == 0){
				Block block = player.getTargetBlock(null, 10);
					if(block.getType() == Material.WOOD_PLATE){
						boolean alreadyRegistered = false;
						for(Plate plate : plates)
							if(twoLocationsEqual(block.getLocation(), plate.getPlate().getLocation()))
								alreadyRegistered = true;
						if(!alreadyRegistered){
							plates.add(new Plate(block, block.getLocation()));
							player.sendMessage(ChatColor.AQUA+"Plate registered!");
						}else
							player.sendMessage(ChatColor.RED+"Plate already registered");
					}else
						player.sendMessage(ChatColor.RED+"Please look at a wooden pressure plate!");
				}else if(args[0].equalsIgnoreCase("cats") || args[0].equalsIgnoreCase("categories")){
					String msg = ChatColor.AQUA+"Categeories: "+ChatColor.DARK_AQUA;
					Category[] cats = Category.values();
					for(Category cat : cats){
						msg += cat.getTheName();
						if(cats[cats.length - 1] != cat)
							msg += ", ";
					}
					player.sendMessage(msg);	
				}
			}else
				player.sendMessage(ChatColor.DARK_RED+"You dont have permission to do this!");
		}
		return false;
	}
	
	private class Runner implements Runnable{
		@Override
		public void run() {
			for(ChestItem i : items){
				Item item = i.getItem();
				if(item.isValid() && item.getLocation().distance(i.getLastLoc()) < .05){
					if(addItemToNearestChest(item))
						items.remove(i);
				}else if(item.isValid())
					i.setLastLoc(item.getLocation());
				else 
					items.remove(i);
			}
		}
	}
	
	private class ChestItem{
		private Location lastLoc;
		private Item item;
		
		public ChestItem(Item i, Location l){
			item = i;
			setLastLoc(l);
		}

		public Location getLastLoc() {return lastLoc;}
		public void setLastLoc(Location lastLoc) {this.lastLoc = lastLoc;}
		public Item getItem() {return item;}
	}
	
	private class SChest{
		private Chest chest;
		private List<Category> categories = new ArrayList<Category>();
		private Chest attached;
		
		public SChest(Chest c){
			setChest(c);
		}
		
		public Chest getChest() {return chest;}
		public void setChest(Chest chest) {this.chest = chest;}
		public List<Category> getCatagories() {return categories;}
		public void addCatagory(Category c){categories.add(c);}
		@SuppressWarnings("unused")
		public Chest getAttached() {return attached;}
		public void setAttached(Chest attached) {this.attached = attached;}
	}
	
	private class Plate{
		private Location location;
		private Block plate;
		
		public Plate(Block p, Location loc){
			location = loc;
			plate = p;
		}

		public Location getLocation() {return location;}
		public Block getPlate() {return plate;}
	}
}