package me.slam1000bob.SensitiveChests;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class Categorizer {
	
	public static List<Category> getCategories(ItemStack i) {
		List<Category> c = new ArrayList<Category>();
		switch(i.getType()){
		case ANVIL:
			break;
		case APPLE:
			c.add(Category.FOOD);
			break;
		case ARROW:
			c.add(Category.TOOLS);
			c.add(Category.MOB_DROPS);
			break;
		case BAKED_POTATO:
			c.add(Category.FOOD);
			break;
		case BEACON:
			c.add(Category.BLOCK);
			break;
		case BED:
			c.add(Category.BLOCK);
			break;
		case BEDROCK:
			c.add(Category.BLOCK);
			break;
		case BED_BLOCK:
			c.add(Category.BLOCK);
			break;
		case BIRCH_WOOD_STAIRS:
			c.add(Category.WOOD);
			c.add(Category.BLOCK);
			break;
		case BLAZE_POWDER:;
			break;
		case BLAZE_ROD:
			c.add(Category.MOB_DROPS);
			break;
		case BOAT:
			c.add(Category.WOOD);
			break;
		case BONE:
			c.add(Category.MOB_DROPS);
			break;
		case BOOK:
			break;
		case BOOKSHELF:
			c.add(Category.BLOCK);
			break;
		case BOOK_AND_QUILL:
			break;
		case BOW:
			c.add(Category.TOOLS);
			break;
		case BOWL:
			c.add(Category.WOOD);
			break;
		case BREAD:
			c.add(Category.FOOD);
			break;
		case BREWING_STAND:
			break;
		case BREWING_STAND_ITEM:
			break;
		case BRICK:
			c.add(Category.BLOCK);
			break;
		case BRICK_STAIRS:
			break;
		case BROWN_MUSHROOM:
			c.add(Category.CROPS);
			c.add(Category.FOOD);
			break;
		case BUCKET:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case BURNING_FURNACE:
			break;
		case CACTUS:
			c.add(Category.CROPS);
			break;
		case CAKE:
			c.add(Category.FOOD);
			break;
		case CAKE_BLOCK:
			break;
		case CARROT:
			c.add(Category.CROPS);
			break;
		case CARROT_ITEM:
			c.add(Category.FOOD);
			break;
		case CARROT_STICK:
			break;
		case CAULDRON:
			break;
		case CAULDRON_ITEM:
			break;
		case CHAINMAIL_BOOTS:
			c.add(Category.ARMOR);
			break;
		case CHAINMAIL_CHESTPLATE:
			c.add(Category.ARMOR);
			break;
		case CHAINMAIL_HELMET:
			c.add(Category.ARMOR);
			break;
		case CHAINMAIL_LEGGINGS:
			c.add(Category.ARMOR);
			break;
		case CHEST:
			break;
		case CLAY:
			break;
		case CLAY_BALL:
			break;
		case CLAY_BRICK:
			break;
		case COAL:
			break;
		case COAL_ORE:
			break;
		case COBBLESTONE:
			c.add(Category.BLOCK);
			break;
		case COBBLESTONE_STAIRS:
			c.add(Category.BLOCK);
			break;
		case COBBLE_WALL:
			break;
		case COCOA:
			break;
		case COMMAND:
			break;
		case COMPASS:
			break;
		case COOKED_BEEF:
			c.add(Category.FOOD);
			break;
		case COOKED_CHICKEN:
			c.add(Category.FOOD);
			break;
		case COOKED_FISH:
			c.add(Category.FOOD);
			break;
		case COOKIE:
			c.add(Category.FOOD);
			break;
		case CROPS:
			c.add(Category.CROPS);
			break;
		case DEAD_BUSH:
			break;
		case DETECTOR_RAIL:
			break;
		case DIAMOND:
			c.add(Category.DIAMOND);
			break;
		case DIAMOND_AXE:
			c.add(Category.DIAMOND);
			c.add(Category.TOOLS);
			break;
		case DIAMOND_BLOCK:
			c.add(Category.DIAMOND);
			c.add(Category.BLOCK);
			break;
		case DIAMOND_BOOTS:
			c.add(Category.DIAMOND);
			c.add(Category.ARMOR);
			break;
		case DIAMOND_CHESTPLATE:
			c.add(Category.DIAMOND);
			c.add(Category.ARMOR);
			break;
		case DIAMOND_HELMET:
			c.add(Category.DIAMOND);
			c.add(Category.ARMOR);
			break;
		case DIAMOND_HOE:
			c.add(Category.DIAMOND);
			c.add(Category.TOOLS);
			break;
		case DIAMOND_LEGGINGS:
			c.add(Category.DIAMOND);
			c.add(Category.ARMOR);
			break;
		case DIAMOND_ORE:
			c.add(Category.DIAMOND);
			c.add(Category.BLOCK);
			break;
		case DIAMOND_PICKAXE:
			c.add(Category.DIAMOND);
			c.add(Category.TOOLS);
			break;
		case DIAMOND_SPADE:
			c.add(Category.DIAMOND);
			c.add(Category.TOOLS);
			break;
		case DIAMOND_SWORD:
			c.add(Category.DIAMOND);
			c.add(Category.TOOLS);
			break;
		case DIODE:
			break;
		case DIODE_BLOCK_OFF:
			break;
		case DIODE_BLOCK_ON:
			break;
		case DIRT:
			break;
		case DISPENSER:
			break;
		case DOUBLE_STEP:
			c.add(Category.BLOCK);
			break;
		case DRAGON_EGG:
			c.add(Category.MOB_DROPS);
			break;
		case EGG:
			c.add(Category.MOB_DROPS);
			break;
		case EMERALD:
			break;
		case EMERALD_BLOCK:
			c.add(Category.BLOCK);
			break;
		case EMERALD_ORE:
			c.add(Category.BLOCK);
			break;
		case EMPTY_MAP:
			break;
		case ENCHANTED_BOOK:
			break;
		case ENCHANTMENT_TABLE:
			break;
		case ENDER_CHEST:
			break;
		case ENDER_PEARL:
			c.add(Category.MOB_DROPS);
			break;
		case ENDER_PORTAL:
			break;
		case ENDER_PORTAL_FRAME:
			break;
		case ENDER_STONE:
			break;
		case EXP_BOTTLE:
			break;
		case EYE_OF_ENDER:
			break;
		case FEATHER:
			c.add(Category.MOB_DROPS);
			break;
		case FENCE:
			c.add(Category.WOOD);
			break;
		case FENCE_GATE:
			c.add(Category.WOOD);
			break;
		case FERMENTED_SPIDER_EYE:
			break;
		case FIRE:
			break;
		case FIREBALL:
			break;
		case FIREWORK:
			break;
		case FIREWORK_CHARGE:
			break;
		case FISHING_ROD:
			break;
		case FLINT:
			break;
		case FLINT_AND_STEEL:
			break;
		case FLOWER_POT:
			break;
		case FLOWER_POT_ITEM:
			break;
		case FURNACE:
			break;
		case GHAST_TEAR:
			c.add(Category.MOB_DROPS);
			break;
		case GLASS:
			c.add(Category.BLOCK);
			break;
		case GLASS_BOTTLE:
			break;
		case GLOWING_REDSTONE_ORE:
			break;
		case GLOWSTONE:
			c.add(Category.BLOCK);
			break;
		case GLOWSTONE_DUST:
			break;
		case GOLDEN_APPLE:
			c.add(Category.GOLD);
			c.add(Category.FOOD);
			break;
		case GOLDEN_CARROT:
			c.add(Category.GOLD);
			c.add(Category.FOOD);
			break;
		case GOLD_AXE:
			c.add(Category.GOLD);
			c.add(Category.TOOLS);
			break;
		case GOLD_BLOCK:
			c.add(Category.GOLD);
			c.add(Category.BLOCK);
			break;
		case GOLD_BOOTS:
			c.add(Category.GOLD);
			c.add(Category.ARMOR);
			break;
		case GOLD_CHESTPLATE:
			c.add(Category.GOLD);
			c.add(Category.ARMOR);
			break;
		case GOLD_HELMET:
			c.add(Category.GOLD);
			c.add(Category.ARMOR);
			break;
		case GOLD_HOE:
			c.add(Category.GOLD);
			c.add(Category.TOOLS);
			break;
		case GOLD_INGOT:
			c.add(Category.GOLD);
			break;
		case GOLD_LEGGINGS:
			c.add(Category.GOLD);
			c.add(Category.ARMOR);
			break;
		case GOLD_NUGGET:
			c.add(Category.GOLD);
			break;
		case GOLD_ORE:
			c.add(Category.GOLD);
			c.add(Category.BLOCK);
			break;
		case GOLD_PICKAXE:
			c.add(Category.GOLD);
			c.add(Category.TOOLS);
			break;
		case GOLD_RECORD:
			c.add(Category.MOB_DROPS);
			break;
		case GOLD_SPADE:
			c.add(Category.GOLD);
			c.add(Category.TOOLS);
			break;
		case GOLD_SWORD:
			c.add(Category.GOLD);
			c.add(Category.TOOLS);
			break;
		case GRASS:
			c.add(Category.BLOCK);
			break;
		case GRAVEL:
			c.add(Category.BLOCK);
			break;
		case GREEN_RECORD:
			c.add(Category.MOB_DROPS);
			break;
		case GRILLED_PORK:
			c.add(Category.FOOD);
			break;
		case HUGE_MUSHROOM_1:
			break;
		case HUGE_MUSHROOM_2:
			break;
		case ICE:
			c.add(Category.BLOCK);
			break;
		case INK_SACK:
			c.add(Category.MOB_DROPS);
			break;
		case IRON_AXE:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case IRON_BLOCK:
			c.add(Category.BLOCK);
			c.add(Category.IRON);
			break;
		case IRON_BOOTS:
			c.add(Category.IRON);
			c.add(Category.ARMOR);
			break;
		case IRON_CHESTPLATE:
			c.add(Category.IRON);
			c.add(Category.ARMOR);
			break;
		case IRON_DOOR:
			c.add(Category.IRON);
			break;
		case IRON_DOOR_BLOCK:
			c.add(Category.IRON);
			break;
		case IRON_FENCE:
			c.add(Category.IRON);
			break;
		case IRON_HELMET:
			c.add(Category.IRON);
			c.add(Category.ARMOR);
			break;
		case IRON_HOE:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case IRON_INGOT:
			c.add(Category.IRON);
			break;
		case IRON_LEGGINGS:
			c.add(Category.IRON);
			c.add(Category.ARMOR);
			break;
		case IRON_ORE:
			c.add(Category.BLOCK);
			c.add(Category.IRON);
			break;
		case IRON_PICKAXE:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case IRON_SPADE:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case IRON_SWORD:
			c.add(Category.IRON);
			c.add(Category.TOOLS);
			break;
		case ITEM_FRAME:
			break;
		case JACK_O_LANTERN:
			break;
		case JUKEBOX:
			c.add(Category.WOOD);
			break;
		case JUNGLE_WOOD_STAIRS:
			break;
		case LADDER:
			c.add(Category.WOOD);
			break;
		case LAPIS_BLOCK:
			break;
		case LAPIS_ORE:
			break;
		case LAVA:
			break;
		case LAVA_BUCKET:
			break;
		case LEATHER:
			c.add(Category.MOB_DROPS);
			c.add(Category.LEATHER);
			break;
		case LEATHER_BOOTS:
			c.add(Category.LEATHER);
			c.add(Category.ARMOR);
			break;
		case LEATHER_CHESTPLATE:
			c.add(Category.LEATHER);
			c.add(Category.ARMOR);
			break;
		case LEATHER_HELMET:
			c.add(Category.LEATHER);
			c.add(Category.ARMOR);
			break;
		case LEATHER_LEGGINGS:
			c.add(Category.LEATHER);
			c.add(Category.ARMOR);
			break;
		case LEAVES:
			c.add(Category.BLOCK);
			break;
		case LEVER:
			break;
		case LOCKED_CHEST:
			c.add(Category.WOOD);
			break;
		case LOG:
			c.add(Category.WOOD);
			c.add(Category.BLOCK);
			break;
		case LONG_GRASS:
			break;
		case MAGMA_CREAM:
			c.add(Category.MOB_DROPS);
			break;
		case MAP:
			break;
		case MELON:
			c.add(Category.FOOD);
			break;
		case MELON_BLOCK:
			c.add(Category.CROPS);
			break;
		case MELON_SEEDS:
			c.add(Category.CROPS);
			break;
		case MELON_STEM:
			c.add(Category.CROPS);
			break;
		case MILK_BUCKET:
			c.add(Category.FOOD);
			break;
		case MINECART:
			break;
		case MOB_SPAWNER:
			break;
		case MONSTER_EGG:
			break;
		case MONSTER_EGGS:
			break;
		case MOSSY_COBBLESTONE:
			break;
		case MUSHROOM_SOUP:
			break;
		case MYCEL:
			c.add(Category.BLOCK);
			break;
		case NETHERRACK:
			c.add(Category.BLOCK);
			break;
		case NETHER_BRICK:
			c.add(Category.BLOCK);
			break;
		case NETHER_BRICK_STAIRS:
			c.add(Category.BLOCK);
			break;
		case NETHER_FENCE:
			break;
		case NETHER_STALK:
			break;
		case NETHER_STAR:
			c.add(Category.MOB_DROPS);
			break;
		case NETHER_WARTS:
			break;
		case NOTE_BLOCK:
			break;
		case OBSIDIAN:
			c.add(Category.BLOCK);
			break;
		case PAINTING:
			break;
		case PAPER:
			break;
		case PISTON_BASE:
			break;
		case PISTON_EXTENSION:
			break;
		case PISTON_MOVING_PIECE:
			break;
		case PISTON_STICKY_BASE:
			break;
		case POISONOUS_POTATO:
			break;
		case PORK:
			c.add(Category.FOOD);
			break;
		case PORTAL:
			break;
		case POTATO:
			c.add(Category.FOOD);
			break;
		case POTATO_ITEM:
			c.add(Category.FOOD);
			break;
		case POTION:
			c.add(Category.POTION);
			break;
		case POWERED_MINECART:
			break;
		case POWERED_RAIL:
			break;
		case PUMPKIN:
			c.add(Category.CROPS);
			break;
		case PUMPKIN_PIE:
			c.add(Category.FOOD);
			break;
		case PUMPKIN_SEEDS:
			c.add(Category.CROPS);
			break;
		case PUMPKIN_STEM:
			break;
		case RAILS:
			break;
		case RAW_BEEF:
			c.add(Category.FOOD);
			break;
		case RAW_CHICKEN:
			c.add(Category.FOOD);
			break;
		case RAW_FISH:
			c.add(Category.FOOD);
			break;
		case RECORD_10:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_11:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_12:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_3:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_4:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_5:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_6:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_7:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_8:
			c.add(Category.MOB_DROPS);
			break;
		case RECORD_9:
			c.add(Category.MOB_DROPS);
			break;
		case REDSTONE:
			break;
		case REDSTONE_LAMP_OFF:
			break;
		case REDSTONE_LAMP_ON:
			break;
		case REDSTONE_ORE:
			break;
		case REDSTONE_TORCH_OFF:
			break;
		case REDSTONE_TORCH_ON:
			break;
		case REDSTONE_WIRE:
			break;
		case RED_MUSHROOM:
			c.add(Category.CROPS);
			c.add(Category.FOOD);
			break;
		case RED_ROSE:
			break;
		case ROTTEN_FLESH:
			break;
		case SADDLE:
			c.add(Category.LEATHER);
			break;
		case SAND:
			c.add(Category.BLOCK);
			break;
		case SANDSTONE:
			break;
		case SANDSTONE_STAIRS:
			break;
		case SAPLING:
			break;
		case SEEDS:
			c.add(Category.CROPS);
			break;
		case SHEARS:
			break;
		case SIGN:
			c.add(Category.WOOD);
			break;
		case SIGN_POST:
			c.add(Category.WOOD);
			break;
		case SKULL:
			break;
		case SKULL_ITEM:
			break;
		case SLIME_BALL:
			break;
		case SMOOTH_BRICK:
			c.add(Category.BLOCK);
			break;
		case SMOOTH_STAIRS:
			c.add(Category.BLOCK);
			break;
		case SNOW:
			break;
		case SNOW_BALL:
			break;
		case SNOW_BLOCK:
			c.add(Category.BLOCK);
			break;
		case SOIL:
			c.add(Category.BLOCK);
			break;
		case SOUL_SAND:
			c.add(Category.BLOCK);
			break;
		case SPECKLED_MELON:
			break;
		case SPIDER_EYE:
			break;
		case SPONGE:
			c.add(Category.BLOCK);
			break;
		case SPRUCE_WOOD_STAIRS:
			c.add(Category.BLOCK);
			break;
		case STATIONARY_LAVA:
			break;
		case STATIONARY_WATER:
			break;
		case STEP:
			c.add(Category.BLOCK);
			c.add(Category.WOOD);
			break;
		case STICK:
			break;
		case STONE:
			c.add(Category.BLOCK);
			c.add(Category.STONE);
			break;
		case STONE_AXE:
			c.add(Category.STONE);
			c.add(Category.TOOLS);
			break;
		case STONE_BUTTON:
			c.add(Category.STONE);
			break;
		case STONE_HOE:
			c.add(Category.STONE);
			c.add(Category.TOOLS);
			break;
		case STONE_PICKAXE:
			c.add(Category.STONE);
			c.add(Category.TOOLS);
			break;
		case STONE_PLATE:
			c.add(Category.STONE);
			break;
		case STONE_SPADE:
			c.add(Category.STONE);
			c.add(Category.TOOLS);
			break;
		case STONE_SWORD:
			c.add(Category.STONE);
			c.add(Category.TOOLS);
			break;
		case STORAGE_MINECART:
			break;
		case STRING:
			c.add(Category.MOB_DROPS);
			break;
		case SUGAR:
			break;
		case SUGAR_CANE:
			c.add(Category.CROPS);
			break;
		case SUGAR_CANE_BLOCK:
			break;
		case SULPHUR:
			break;
		case THIN_GLASS:
			break;
		case TNT:
			break;
		case TORCH:
			break;
		case TRAP_DOOR:
			c.add(Category.WOOD);
			break;
		case TRIPWIRE:
			break;
		case TRIPWIRE_HOOK:
			break;
		case VINE:
			break;
		case WALL_SIGN:
			c.add(Category.WOOD);
			break;
		case WATCH:
			break;
		case WATER:
			break;
		case WATER_BUCKET:
			break;
		case WATER_LILY:
			break;
		case WEB:
			break;
		case WHEAT:
			c.add(Category.CROPS);
			break;
		case WOOD:
			c.add(Category.BLOCK);
			c.add(Category.WOOD);
			break;
		case WOODEN_DOOR:
			c.add(Category.WOOD);
			break;
		case WOOD_AXE:
			c.add(Category.TOOLS);
			c.add(Category.WOOD);
			break;
		case WOOD_BUTTON:
			c.add(Category.WOOD);
			break;
		case WOOD_DOOR:
			c.add(Category.WOOD);
			break;
		case WOOD_DOUBLE_STEP:
			c.add(Category.BLOCK);
			c.add(Category.WOOD);
			break;
		case WOOD_HOE:
			c.add(Category.TOOLS);
			c.add(Category.WOOD);
			break;
		case WOOD_PICKAXE:
			c.add(Category.TOOLS);
			c.add(Category.WOOD);
			break;
		case WOOD_PLATE:
			c.add(Category.WOOD);
			break;
		case WOOD_SPADE:
			c.add(Category.TOOLS);
			c.add(Category.WOOD);
			break;
		case WOOD_STAIRS:
			c.add(Category.BLOCK);
			c.add(Category.WOOD);
			break;
		case WOOD_STEP:
			c.add(Category.BLOCK);
			c.add(Category.WOOD);
			break;
		case WOOD_SWORD:
			c.add(Category.TOOLS);
			c.add(Category.WOOD);
			break;
		case WOOL:
			break;
		case WORKBENCH:
			c.add(Category.WOOD);
			break;
		case WRITTEN_BOOK:
			break;
		case YELLOW_FLOWER:
			break;
		default:
			break;
		}
		return c;
	}

}