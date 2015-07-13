package com.pl10123.dragoncraft.block;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.tileentity.TileCore;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DraconicCore extends BlockContainer{

	public DraconicCore() {
		super(Material.iron);
		setHardness(1.45F);
		setHarvestLevel("pickaxe", 2);
		setBlockName("draconicCore");
		setCreativeTab(Core.dragonTab);
	}
	
	

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon(Core.MODID + ":" + this.getUnlocalizedName().substring(5));
	}



	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileCore();
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	
	
	

}
