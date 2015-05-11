package com.pl10123.dragoncraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKeeper extends ModelBase
{
  //fields
    ModelRenderer Torso;
    ModelRenderer Lleg;
    ModelRenderer rleg;
    ModelRenderer Larm;
    ModelRenderer Rarm;
    ModelRenderer Head;
  
  public ModelKeeper()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Torso = new ModelRenderer(this, 0, 0);
      Torso.addBox(0F, 0F, 0F, 8, 10, 6);
      Torso.setRotationPoint(-4F, 4F, -3F);
      Torso.setTextureSize(64, 32);
      Torso.mirror = true;
      setRotation(Torso, 0F, 0F, 0F);
      Lleg.mirror = true;
      Lleg = new ModelRenderer(this, 8, 16);
      Lleg.addBox(0F, 0F, 0F, 2, 10, 4);
      Lleg.setRotationPoint(1F, 14F, -2F);
      Lleg.setTextureSize(64, 32);
      Lleg.mirror = true;
      setRotation(Lleg, 0F, 0F, 0F);
      Lleg.mirror = false;
      rleg = new ModelRenderer(this, 8, 16);
      rleg.addBox(0F, 0F, 0F, 2, 10, 4);
      rleg.setRotationPoint(-3F, 14F, -2F);
      rleg.setTextureSize(64, 32);
      rleg.mirror = true;
      setRotation(rleg, 0F, 0F, 0F);
      Larm.mirror = true;
      Larm = new ModelRenderer(this, 0, 16);
      Larm.addBox(0F, 0F, 0F, 2, 8, 2);
      Larm.setRotationPoint(4F, 4F, -1F);
      Larm.setTextureSize(64, 32);
      Larm.mirror = true;
      setRotation(Larm, 0F, 0F, 0F);
      Larm.mirror = false;
      Rarm = new ModelRenderer(this, 0, 16);
      Rarm.addBox(0F, 0F, 0F, 2, 8, 2);
      Rarm.setRotationPoint(-6F, 4F, -1F);
      Rarm.setTextureSize(64, 32);
      Rarm.mirror = true;
      setRotation(Rarm, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 28, 0);
      Head.addBox(0F, 0F, 0F, 6, 6, 4);
      Head.setRotationPoint(-3F, -2F, -2F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Torso.render(f5);
    Lleg.render(f5);
    rleg.render(f5);
    Larm.render(f5);
    Rarm.render(f5);
    Head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Rarm.rotateAngleZ = 0.0F;
    this.Larm.rotateAngleZ = 0.0F;
    this.rleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Lleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rleg.rotateAngleY = 0.0F;
    this.Lleg.rotateAngleY = 0.0F;
  }

}
