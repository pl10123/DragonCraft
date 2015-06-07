package com.pl10123.dragoncraft.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.pl10123.dragoncraft.api.entityproperties.Mana;
import com.pl10123.dragoncraft.proxy.CommonProxy;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModEventHandler {
	
	public static int tickinGame = 0;
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
//		if(event.entity instanceof EntityPlayer && SoulBank.get((EntityPlayer) event.entity) == null){ //Souls
//			SoulBank.register((EntityPlayer) event.entity);
//		}
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
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent e){
		GuiScreen currentScreen = Minecraft.getMinecraft().currentScreen;
		if(currentScreen == null || !currentScreen.doesGuiPauseGame()){
			tickinGame++;
		}
	}
	
	

}
