package com.pl10123.dragoncraft.api.crafting;

import java.util.List;

import net.minecraft.item.ItemStack;

public class AltarRecipe {
	
	ItemStack output;
	List<ItemStack> inputs;
	
	public AltarRecipe(List<ItemStack> inputItems, ItemStack result){
		
		int num = inputItems.size();
		if(num > 0 && num <= 4 && result != null){
			this.output = result;
			this.inputs = inputItems;
		}
		
	}

}
