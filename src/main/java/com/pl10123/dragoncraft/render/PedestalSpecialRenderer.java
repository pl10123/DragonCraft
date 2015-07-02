package com.pl10123.dragoncraft.render;

import org.lwjgl.opengl.GL11;

import com.pl10123.dragoncraft.tileentity.TilePedestal;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;

public class PedestalSpecialRenderer extends TileEntitySpecialRenderer{

	EntityItem item = null;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		int Slot = 0;
		TilePedestal pedestal = (TilePedestal) te;
		
		if(item == null || item.getEntityItem().getItem() != pedestal.getStackInSlot(Slot).getItem()){
			item = new EntityItem(pedestal.getWorldObj(), x, y, z, pedestal.getStackInSlot(Slot));
		}
		
		GL11.glPushMatrix();
		
		this.item.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
		GL11.glRotatef(180, 0, 1, 1);
		RenderManager.instance.renderEntityWithPosYaw(this.item, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		
		
		GL11.glPopMatrix();
	}

}
