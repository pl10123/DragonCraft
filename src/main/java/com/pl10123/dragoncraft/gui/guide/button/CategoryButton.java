package com.pl10123.dragoncraft.gui.guide.button;

import org.lwjgl.opengl.GL11;

import com.pl10123.dragoncraft.api.guide.EntryCategory;
import com.pl10123.dragoncraft.gui.guide.GuiGuideMain;
import com.pl10123.dragoncraft.render.ClientRenderHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;

public class CategoryButton extends GuiButton{

	
	private GuiGuideMain gui;
	float ticksHover = 0F;
	 
	public CategoryButton(GuiGuideMain gui, int id, int xPos, int yPos, int width, int height, EntryCategory category) {
		super(id, xPos, yPos, width, height, category.getCategoryName());
		this.gui = gui;
	}

	@Override
	public void drawButton(Minecraft mc, int mx, int my) {
		boolean inButton = mx >= xPosition && my >= yPosition && mx < xPosition + width && my < yPosition + height;
		float time = 5F;
		if(inButton) {
			ticksHover = Math.min(time, ticksHover + gui.timeDelta);	
		}else{
			ticksHover = Math.max(0F, ticksHover - gui.timeDelta);
		}
		
		float s = 1F / 48F;
		float defAlpha = 0.3F;
		float alpha = ticksHover / time * (1F - defAlpha) + defAlpha;

		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, alpha);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		ClientRenderHelper.drawTexturedModalRect(xPosition * 2, yPosition * 2, zLevel * 2, 0, 0, 48, 48, s, s);
		GL11.glPopMatrix();
	}
	
	

}
