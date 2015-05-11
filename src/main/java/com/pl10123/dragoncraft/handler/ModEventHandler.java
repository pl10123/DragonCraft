package com.pl10123.dragoncraft.handler;

import com.pl10123.dragoncraft.api.soulbank.SoulBank;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

public class ModEventHandler {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if(event.entity instanceof EntityPlayer && SoulBank.get((EntityPlayer) event.entity) == null){
			SoulBank.register((EntityPlayer) event.entity);
		}
	}

}
