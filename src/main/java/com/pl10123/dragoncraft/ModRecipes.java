package com.pl10123.dragoncraft;

import net.minecraft.item.ItemStack;

import com.pl10123.dragoncraft.block.ModBlocks;
import com.pl10123.dragoncraft.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void registerRecipes(){
		registerSmelting();
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(ModBlocks.draconicOre, new ItemStack(ModItems.draconicIngot), 0.3F);
	}

}
