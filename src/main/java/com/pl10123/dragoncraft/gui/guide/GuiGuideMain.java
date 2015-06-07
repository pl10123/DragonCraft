package com.pl10123.dragoncraft.gui.guide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.api.guide.EntryCategory;
import com.pl10123.dragoncraft.api.guide.GuideHelper;
import com.pl10123.dragoncraft.handler.ModEventHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class GuiGuideMain extends GuiScreen{
	
	public float timeDelta;
	public int lastTime;

	private static ResourceLocation rsl = new ResourceLocation(Core.MODID + ":" + "textures/gui/guiguide.png");
	private List<EntryCategory>entryCategoryList;
	
	int guiWidth = 146;
	int guiHeight = 180;
	int top, left;
	
	public GuiGuideMain(EntityPlayer player){
		
		
	}
	
	
	
	@Override
	public void initGui() {
		entryCategoryList = new ArrayList(GuideHelper.getCategoryList());
		Collections.sort(entryCategoryList);
		
		super.initGui();
		lastTime = ModEventHandler.tickinGame;
	}



	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		float time = ModEventHandler.tickinGame + p_73863_3_;
		timeDelta = time - lastTime;
		left = width/2 - guiWidth/2;
		top = height/2 - guiHeight/2;
		mc.renderEngine.bindTexture(rsl);
		drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
		
	}

	


	@Override
	protected void actionPerformed(GuiButton p_146284_1_) {
		super.actionPerformed(p_146284_1_);
	}



	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	
	
}
