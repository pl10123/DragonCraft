package com.pl10123.dragoncraft.handler;

import com.pl10123.dragoncraft.ModConstants;
import com.pl10123.dragoncraft.gui.guide.GuiGuideMain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
			case ModConstants.GUI_GUIDE:
				return new GuiGuideMain(player);
		}
		return null;
	}

}
