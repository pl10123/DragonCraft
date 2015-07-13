package com.pl10123.dragoncraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.tileentity.TilePedestal;

public class DraconicPedestal extends BlockContainer{

	public DraconicPedestal() {
		super(Material.glass);
		setCreativeTab(Core.dragonTab);
		setBlockName("draconicPedestal");
		
	}
	
	

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon(Core.MODID + ":" + this.getUnlocalizedName().substring(5));
	}



	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	



	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}



	@Override
	public boolean onBlockActivated(World world, int x,	int y, int z, EntityPlayer player,int i, float f, float f1,float f2) {
		if(world.isRemote){
			return true;
		}
		TilePedestal te = (TilePedestal) world.getTileEntity(x, y, z);
		
		if(te.getStackInSlot(0) == null){
			if(player.getCurrentEquippedItem() != null){
				ItemStack iStack = player.getCurrentEquippedItem().copy();
				iStack.stackSize = 1;
				te.setInventorySlotContents(0, iStack);
				player.getCurrentEquippedItem().stackSize -=1;
				System.out.println("You added an itemStack of: " + iStack.getDisplayName());
				if (player.getCurrentEquippedItem().stackSize == 0){
					player.setCurrentItemOrArmor(0, null);
				}
				
				player.inventory.markDirty();
				return true;
			}
			
		}else
		if(player.isSneaking()){
			if(player.getCurrentEquippedItem() == null){
				if(te.getStackInSlot(0) != null){
					ItemStack iStack = te.getStackInSlot(0).copy();
					player.setCurrentItemOrArmor(0, iStack);
					te.setInventorySlotContents(0, null);
					player.inventory.markDirty();
					
					return true;
				}
			}
		}
		
		return false;
	}



	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		System.out.println("Created TileEntity");
		return new TilePedestal();
	}



	@Override
	public void breakBlock(World world, int x, int y,
			int z, Block p_149749_5_, int p_149749_6_) {
		TilePedestal te = (TilePedestal) world.getTileEntity(x, y, z);
		if (te.getStackInSlot(0) != null){
			EntityItem item = new EntityItem(world, (double) x, (double) y, (double) z, te.getStackInSlot(0));
		}
	}
	
	



	

}
