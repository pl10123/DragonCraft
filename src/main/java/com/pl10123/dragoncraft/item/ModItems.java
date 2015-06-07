package com.pl10123.dragoncraft.item;

import com.pl10123.dragoncraft.Core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	
	public static Item dragonGuide;
	
	
	public static void initItems(){
		dragonGuide = new ItemGuide().setUnlocalizedName("DragonGuide");
	}
		
	
	public static void registerItems(){
		GameRegistry.registerItem(dragonGuide, "DragonGuide");
	}
}
