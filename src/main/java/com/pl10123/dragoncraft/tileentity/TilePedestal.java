package com.pl10123.dragoncraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TilePedestal extends TileDragonCraft implements IInventory{

	public static final int[] slots = { 0 };
	private ItemStack[]  itemSlot = new ItemStack[1];
	
	@Override
	public void readCustomNBT(NBTTagCompound nbtTag) {
        System.out.println("Loading from NBT");
		NBTTagList nbttaglist = nbtTag.getTagList("Items", 10);
        this.itemSlot = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount();i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemSlot.length)
            {
            	System.out.println("Found this itemStack: " + ItemStack.loadItemStackFromNBT(nbttagcompound1).getDisplayName());
                this.itemSlot[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
	}

	@Override
	public void writeCustomNBT(NBTTagCompound nbtTag) {
		System.out.println("Starting Write to NBT");
		NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemSlot.length; i++)
        {
            if (this.itemSlot[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemSlot[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbtTag.setTag("Items", nbttaglist);
		System.out.println("Done writing nbt");
	
	}

	public boolean canUpdate() {
		return false;
	};

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.itemSlot[slot];
	}

	@Override
	public ItemStack decrStackSize(int slotID, int num) {
		if (this.itemSlot[slotID] != null)
        {
            ItemStack itemstack;
            if (this.itemSlot[slotID].stackSize <= num) {
                itemstack = this.itemSlot[slotID];
                this.itemSlot[slotID] = null;
                markDirty();
                return itemstack;
            }
                itemstack = this.itemSlot[slotID].splitStack(num);

                if (this.itemSlot[slotID].stackSize == 0) {
                    this.itemSlot[slotID] = null;
                }
                markDirty();
                return itemstack;
        }
            return null;
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int id) {
		if (this.itemSlot[id] != null)
        {
            ItemStack itemstack = this.itemSlot[id];
            this.itemSlot[id] = null;
            return itemstack;
        }
        return null;
	}

	@Override
	public void setInventorySlotContents(int slotID, ItemStack itemStack) {
		this.itemSlot[slotID] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
        markDirty();
        if (!this.worldObj.isRemote){
        	this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}

	
	
	
	
	

}
