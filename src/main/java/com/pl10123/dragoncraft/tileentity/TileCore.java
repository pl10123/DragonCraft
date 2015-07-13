package com.pl10123.dragoncraft.tileentity;

import net.minecraft.tileentity.TileEntity;


public class TileCore extends TileDragonCraft{

	private boolean isActive = false;
	private boolean isCrafting = false;
	
	@Override
	public void updateEntity() {
		checkIfActive();
		if(isActive) System.out.println("ACTIVE");
		
	}
	
	private void checkIfActive(){
		int x = xCoord;
		int y = yCoord;
		int z = zCoord;
		
		TileEntity te = worldObj.getTileEntity(x+2, y, z-2);
		TileEntity te2 = worldObj.getTileEntity(x+2, y, z+2);
		TileEntity te3 = worldObj.getTileEntity(x-2, y, z+2);
		TileEntity te4 = worldObj.getTileEntity(x-2, y, z-2);
		
		if(te instanceof TilePedestal && te2 instanceof TilePedestal && te3 instanceof TilePedestal && te4 instanceof TilePedestal){
			isActive = true;
		}else{
			isActive = false;
		}
	}
	
	
	
	
	
	
	
	

}
