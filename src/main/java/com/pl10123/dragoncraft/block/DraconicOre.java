package com.pl10123.dragoncraft.block;

import java.util.Random;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.item.ItemDraconicIngot;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DraconicOre extends Block {

	protected DraconicOre() {
		
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(Core.dragonTab);
		this.setBlockName("DraconicOre");
		this.setHardness(4.0F);
		this.setResistance(3.0F);
		this.setStepSound(soundTypeStone);
	}
	


	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon(Core.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	

}
