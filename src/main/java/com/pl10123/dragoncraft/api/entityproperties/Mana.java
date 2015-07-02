package com.pl10123.dragoncraft.api.entityproperties;

import java.io.DataOutputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.network.packet.SyncPlayerProperties;
import com.pl10123.dragoncraft.proxy.CommonProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Mana implements IExtendedEntityProperties{
	
	public static final int MANA_WATHCER = 22;
	public static final String Property = "Mana";
	
	private final EntityPlayer entity;
	
	private int maxMana;
	private int currentMana;
	
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

	public boolean consumeMana(int i) {
		boolean sufficient = i <= this.currentMana;
		// Consume the amount anyway; if it's more than the player's current mana,
		// mana will be set to 0
		this.currentMana -= (i < this.currentMana ? i : this.currentMana);
		// Return if the player had enough mana
		this.loadProxyData(this.entity);
		return sufficient;
		}

	public void replenishMana() {
		this.currentMana = this.maxMana;
		this.loadProxyData(this.entity);
	}
	
	public void addMana(int amount){
		int newMana = this.currentMana + amount;
		if(newMana >= this.maxMana){
			this.currentMana = this.maxMana;
		} else {
			this.currentMana = newMana;
		}
		this.loadProxyData(this.entity);
	}
	
	private static final String getSaveKey(EntityPlayer player) {
		// no longer a username field, so use the command sender name instead:
		return player.getCommandSenderName() + ":" + Property;
		}

		public static final void loadProxyData(EntityPlayer player) {
		Mana playerData = Mana.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		if (savedData != null) { playerData.loadNBTData(savedData); }
		// we are replacing the entire sync() method with a single line; more on packets later
		// data can by synced just by sending the appropriate packet, as everything is handled internally by the packet class
		Core.packetPipeline.sendTo(new SyncPlayerProperties(player), (EntityPlayerMP) player);
		}

}
