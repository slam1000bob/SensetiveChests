package me.slam1000bob.SensitiveChests;

public enum Category {
	 FOOD ("food",10),
	 TOOLS ("tools",12),
	 MOB_DROPS ("mob drops",9),
	 WOOD ("wood",6),
	 BLOCK ("block",13),
	 CROPS ("crops",1),
	 IRON ("iron",3),
	 DIAMOND ("diamond",2),
	 ARMOR ("armor",11),
	 POTION ("potion",8),
	 LEATHER ("leather",7),
	 STONE ("stone",5),
	 GOLD ("gold",4);
	 
	 private String name;
	 private int priority;
	 
	 private Category(String name, int priority){
		 this.name = name;
		 
	 }
	 
	 public String getTheName(){
		 return name;
	 }
	 
	 public int getPriority(){
		 return priority;
	 }
}
