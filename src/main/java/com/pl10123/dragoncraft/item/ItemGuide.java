package com.pl10123.dragoncraft.item;

import com.pl10123.dragoncraft.Core;
import com.pl10123.dragoncraft.ModConstants;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGuide extends Item{

	
	public ItemGuide(){
		this.setCreativeTab(Core.dragonTab);
	}
	
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if(!world.isRemote){
			return false;
		} else {
			System.out.println("Opening GUI!");
			player.openGui(Core.modInstance, ModConstants.GUI_GUIDE, world, x, y, z);
			return true;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		
		
		player.openGui(Core.modInstance, ModConstants.GUI_GUIDE, world, 0, 0, 0);
		return itemStack;
	}
	
	

}