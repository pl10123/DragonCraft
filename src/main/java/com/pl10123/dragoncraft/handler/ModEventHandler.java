package com.pl10123.dragoncraft.handler;

import com.pl10123.dragoncraft.api.entityproperties.Mana;
import com.pl10123.dragoncraft.api.entityproperties.SoulBank;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

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
			Mana.get((EntityPlayer) event.entity).loadProxyData((EntityPlayer) event.entity);
		}
	}
	
	

}
