package com.pl10123.dragoncraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	
	public static Block draconicOre;
	
	public static void initBlocks(){
		draconicOre = new DraconicOre();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(draconicOre, "DraconicOre");
	}

}
