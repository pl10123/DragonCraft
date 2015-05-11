package com.pl10123.dragoncraft.handler;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.pl10123.dragoncraft.Core;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	
	public static void registerEntities(Class entityClass, String name){
		int EntityID = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int subColor = random.nextInt() * 16777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, EntityID);
		EntityRegistry.addSpawn(entityClass, 70, 1, 1, EnumCreatureType.ambient, BiomeGenBase.hell, BiomeGenBase.plains, BiomeGenBase.desert);
		EntityRegistry.registerModEntity(entityClass, name, EntityID, Core.modInstance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(EntityID), new EntityList.EntityEggInfo(EntityID, mainColor, subColor));
	}

}
