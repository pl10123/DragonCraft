package com.pl10123.dragoncraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class DragonicCore extends Block{
	
	public DragonicCore(){
		super(Material.rock);
		this.setResistance(2.5F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (player.isSneaking()){
			System.out.println("Starting Crafting");
			return true;
		}
		return false;
	}
	
	
	
	

}
