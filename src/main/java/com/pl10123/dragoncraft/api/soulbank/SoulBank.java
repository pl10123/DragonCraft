package com.pl10123.dragoncraft.api.soulbank;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class SoulBank implements IExtendedEntityProperties{

	public static final String Property = "SoulBank";
	
	private final EntityPlayer entity;
	
	private int currentSouls, maxSouls, usedSouls;
	
	public SoulBank(EntityPlayer entity){
		this.entity = entity;
		this.currentSouls = this.usedSouls = 0;
	}
	
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(Property, new SoulBank(player));
	}
	
	public static final SoulBank get(EntityPlayer entity){
		return (SoulBank) entity.getExtendedProperties(Property);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setInteger("CurrentSouls", this.currentSouls);
		nbtTag.setInteger("UsedSouls", this.usedSouls);
		compound.setTag(Property, nbtTag);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound nbtTag = (NBTTagCompound) compound.getTag(Property);
		this.currentSouls = nbtTag.getInteger("CurrentSouls");
		this.usedSouls = nbtTag.getInteger("UsedSouls");
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public boolean hasEnoughSouls(int required){
		boolean sufficient = required <= this.currentSouls;
		return sufficient;
	}
	
	public int getCurrentSouls(){
		return this.currentSouls;
	}
	
	public int getUsedSouls(){
		return this.usedSouls;
	}
	

}
