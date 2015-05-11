package com.pl10123.dragoncraft.proxy;

import com.pl10123.dragoncraft.entity.EntityDragKeeper;
import com.pl10123.dragoncraft.model.ModelKeeper;
import com.pl10123.dragoncraft.render.RenderKeeper;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	public void registerRenderThings(){
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityDragKeeper.class, new RenderKeeper(new ModelKeeper(), 0.3F));
	}

}
