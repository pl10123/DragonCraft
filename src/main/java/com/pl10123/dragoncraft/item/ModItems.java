package com.pl10123.dragoncraft.item;

import com.pl10123.dragoncraft.Core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	
	public static Item dragonGuide;
	public static Item draconicIngot;
	
	
	public static void initItems(){
		System.out.println("Initialising items");
		dragonGuide = new ItemGuide().setUnlocalizedName("DragonGuide");
		draconicIngot = new ItemDraconicIngot("draconicIngot");
	}
		
	
	public static void registerItems(){
		GameRegistry.registerItem(dragonGuide, "DragonGuide");
		GameRegistry.registerItem(draconicIngot, "draconicIngot");
	}
}
