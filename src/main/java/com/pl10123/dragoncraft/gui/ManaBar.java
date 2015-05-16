package com.pl10123.dragoncraft.gui;

import org.lwjgl.opengl.GL11;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.api.entityproperties.Mana;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

@SideOnly(Side.CLIENT)
public class ManaBar extends Gui{
	
	private Minecraft mc;
	
	ResourceLocation rsc = new ResourceLocation(Core.MODID + ":" + "textures/gui/mana_bar.png");
	public ManaBar(Minecraft mc){
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event){
		
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE){
			return;
		}
		
		Mana property = Mana.get(this.mc.thePlayer);
		
		if (property == null || property.getMaxMana() == 0){
			return;
		}
		
		int x = 4;
		int y = event.resolution.getScaledHeight() - 10;
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		this.mc.getTextureManager().bindTexture(rsc);
		
		this.drawTexturedModalRect(x, y, 0, 0, 102, 5);
		
		int manaWidth = (int) (((float) property.getcurrentMana() / property.getMaxMana()) * 100);
		this.drawTexturedModalRect(x, y, 0, 5, manaWidth, 5);
	}
	
	

}
