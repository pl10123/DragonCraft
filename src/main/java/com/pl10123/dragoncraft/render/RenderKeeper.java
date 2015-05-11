package com.pl10123.dragoncraft.render;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.entity.EntityDragKeeper;
import com.pl10123.dragoncraft.model.ModelKeeper;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderKeeper extends RenderLiving {
	
	public static final ResourceLocation texture = new ResourceLocation(Core.MODID + ":" + "textures/model/Keeper.png");
	
	protected ModelKeeper entityKeeper;

	public RenderKeeper(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
		
		entityKeeper = ((ModelKeeper) mainModel);
		
	}
	
	public void renderKeeper(EntityDragKeeper entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderKeeper((EntityDragKeeper) entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderKeeper((EntityDragKeeper) entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return texture;
	}

	

}
