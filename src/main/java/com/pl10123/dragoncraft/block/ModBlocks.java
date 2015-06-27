package com.pl10123.dragoncraft.block;

import com.pl10123.dragoncraft.tileentity.TilePedestal;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block draconicOre;
	public static Block draconicPedestal;
		
	public static void initBlocks(){
		draconicOre = new DraconicOre();
		draconicPedestal = new DraconicPedestal();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(draconicOre, "DraconicOre");
		GameRegistry.registerBlock(draconicPedestal, "draconicPedestal");
	}


}
