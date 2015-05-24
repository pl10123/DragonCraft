package com.pl10123.dragoncraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGuide extends Item{

	
	public ItemGuide(){
	}
	
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player,
			World world, int x, int y, int z,
			int p_77648_7_, float p_77648_8_, float p_77648_9_,
			float p_77648_10_) {
		return super
				.onItemUse(itemStack, player, world, x, y,
						z, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) {
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
	

}