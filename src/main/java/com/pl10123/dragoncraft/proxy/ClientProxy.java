package com.pl10123.dragoncraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.pl10123.dragoncraft.entity.EntityDragKeeper;
import com.pl10123.dragoncraft.model.ModelKeeper;
import com.pl10123.dragoncraft.render.RenderKeeper;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy{
	
	public void registerRenderThings(){
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityDragKeeper.class, new RenderKeeper(new ModelKeeper(), 0.3F));
	}

	@Override
	public EntityPlayer getEntityPlayer(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getEntityPlayer(ctx));
	}

	public void init() {
	}

	public void registerTileEntities() {
	}
	
	
	
	
	
	

}
