package com.pl10123.dragoncraft.handler;

import com.pl10123.dragoncraft.api.entityproperties.Mana;
import com.pl10123.dragoncraft.api.entityproperties.SoulBank;
import com.pl10123.dragoncraft.proxy.CommonProxy;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class ModEventHandler {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && SoulBank.get((EntityPlayer) event.entity) == null){ //Souls
			SoulBank.register((EntityPlayer) event.entity);
		}
		if(event.entity instanceof EntityPlayer && Mana.get((EntityPlayer) event.entity) == null){ //Mana
			Mana.register((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent
	public void onEntityJoined(EntityJoinWorldEvent event){
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			NBTTagCompound nbt = CommonProxy.getEntityData(((EntityPlayer) event.entity).getDisplayName() + ":" + Mana.Property);
			if(nbt != null){
				((Mana) event.entity.getExtendedProperties(Mana.Property)).loadNBTData(nbt);
			}
			Mana.get((EntityPlayer) event.entity).loadProxyData((EntityPlayer) event.entity);
		}
	}
	
	@SubscribeEvent
	public void onEntityDeadth(LivingDeathEvent event){
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer){
			NBTTagCompound nbt = new NBTTagCompound();
			((Mana)(event.entity.getExtendedProperties(Mana.Property))).saveNBTData(nbt);
			CommonProxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName() + ":" + Mana.Property, nbt);
		}
	}
	
	

}
