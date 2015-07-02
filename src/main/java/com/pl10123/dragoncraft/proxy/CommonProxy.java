package com.pl10123.dragoncraft.proxy;

import java.util.HashMap;
import java.util.Map;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.handler.GuiHandler;
import com.pl10123.dragoncraft.tileentity.TilePedestal;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;


public class CommonProxy {
	
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderThings(){
		
	}
	
	/**
	 * returns a side-appropriate EntityPlayer for message handling
	 */
	
	public EntityPlayer getEntityPlayer(MessageContext ctx){
		return ctx.getServerHandler().playerEntity;
	}
	
	public static NBTTagCompound getEntityData(String name)	{
		return extendedEntityData.remove(name);
	}
	
	/**
	* Adds an entity's custom data to the map for temporary storage
	* @param compound An NBT Tag Compound that stores the IExtendedEntityProperties data only
	*/
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
	extendedEntityData.put(name, compound);
	}

	public void init() {
		System.out.println("INIT Proxy");
		registerTileEntities();
	}
	
	public void registerTileEntities(){
		
	}

}


