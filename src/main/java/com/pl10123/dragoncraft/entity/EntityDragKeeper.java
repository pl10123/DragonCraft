package com.pl10123.dragoncraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityDragKeeper extends EntityMob{
	
	public EntityDragKeeper(World world){
		super(world);
	}
	
	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	    }

}
