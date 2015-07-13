package com.pl10123.dragoncraft.block;

import net.minecraft.block.Block;

import com.pl10123.dragoncraft.tileentity.TileCore;
import com.pl10123.dragoncraft.tileentity.TilePedestal;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block draconicOre;
	public static Block draconicPedestal;
	public static Block draconicCore;
		
	public static void initBlocks(){
		draconicOre = new DraconicOre();
		draconicPedestal = new DraconicPedestal();
		draconicCore = new DraconicCore();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(draconicOre, "DraconicOre");
		GameRegistry.registerBlock(draconicPedestal, "draconicPedestal");
		GameRegistry.registerBlock(draconicCore, "draconicCore");
	}
	
	public static void registerTiles(){
		GameRegistry.registerTileEntity(TilePedestal.class, "PedestalTile");
		GameRegistry.registerTileEntity(TileCore.class, "CoreTile");
	}


}
