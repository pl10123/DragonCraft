package com.pl10123.dragoncraft.proxy;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;


public class CommonProxy {
	
	public void registerRenderThings(){
		
	}
	
	/**
	 * returns a side-appropriate EntityPlayer for message handling
	 */
	
	public EntityPlayer getEntityPlayer(MessageContext ctx){
		return ctx.getServerHandler().playerEntity;
	}

}
