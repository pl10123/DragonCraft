package com.pl10123.dragoncraft.api.entityproperties;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Mana implements IExtendedEntityProperties{
	
	
	public static final String Property = "Mana";
	
	private final EntityPlayer entity;
	
	private int currentMana, maxMana;
	
	public Mana(EntityPlayer entity){
		this.entity = entity;
		this.currentMana = maxMana = 50;
	}
	
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(Property, new Mana(player));
	}
	
	public static final Mana get(EntityPlayer entity){
		return (Mana) entity.getExtendedProperties(Property);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("CurrentMana", this.currentMana);
		nbt.setInteger("MaxMana", this.maxMana);
		compound.setTag(Property, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = (NBTTagCompound) compound.getTag(Property);
		this.currentMana = nbt.getInteger("CurrentMana");
		this.maxMana = nbt.getInteger("MaxMana");
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public boolean hasEnoughMana(int cost){
		boolean sufficient = cost <= this.currentMana;
		return sufficient;
	}
	
	public int getMaxMana(){
		return this.maxMana;
	}
	
	public int getcurrentMana(){
		return this.currentMana;
	}

}
