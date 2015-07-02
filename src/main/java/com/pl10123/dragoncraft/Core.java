package com.pl10123.dragoncraft;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.pl10123.dragoncraft.api.guide.EntryCategory;
import com.pl10123.dragoncraft.api.guide.GuideHelper;
import com.pl10123.dragoncraft.block.ModBlocks;
import com.pl10123.dragoncraft.entity.EntityDragKeeper;
import com.pl10123.dragoncraft.gui.ManaBar;
import com.pl10123.dragoncraft.handler.EntityHandler;
import com.pl10123.dragoncraft.handler.GuiHandler;
import com.pl10123.dragoncraft.handler.ModEventHandler;
import com.pl10123.dragoncraft.item.ModItems;
import com.pl10123.dragoncraft.network.packet.PacketPipeline;
import com.pl10123.dragoncraft.proxy.CommonProxy;
import com.pl10123.dragoncraft.tileentity.TilePedestal;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(name=Core.MODNAME, modid=Core.MODID, version=Core.VERSION )
public class Core {
	public static final String MODNAME = "DragonCraft";
	public static final String VERSION = "0.1";
	public static final String MODID = "dragoncraft";
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	@SidedProxy(clientSide="com.pl10123.dragoncraft.proxy.ClientProxy", serverSide="com.pl10123.dragoncraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static Core modInstance;
	
	public static CreativeTabs dragonTab;
	
	public static GuiHandler guiHandler = new GuiHandler();
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e){
		dragonTab = new CreativeTabs("DragonCraft") {
			
			@Override
			public Item getTabIconItem() {
				return ModItems.draconicIngot;
			}
		};
		ModItems.initItems();
		ModItems.registerItems();
		
		ModBlocks.initBlocks();
		ModBlocks.registerBlocks();
		System.out.println("Init TileEntities");
		GameRegistry.registerTileEntity(TilePedestal.class, "PedestalEntity");
		
	}
	
	
	@EventHandler
	public static void init(FMLInitializationEvent e){
		
		System.out.println("Starting init Phase");
		//proxy.init();
		
		
		//proxy.registerRenderThings();
		//EntityHandler.registerEntities(EntityDragKeeper.class, "DragonKeeper");
		GameRegistry.registerItem(new Testitem().setCreativeTab(dragonTab).setUnlocalizedName("testitem"), "testitem");
		packetPipeline.initialise();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(modInstance, guiHandler);
		
		//EntryCategory test = new EntryCategory("TEST", 1);
		//GuideHelper.registerCattoList(test);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		
		if(FMLCommonHandler.instance().getEffectiveSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new ManaBar(Minecraft.getMinecraft()));
		}
		packetPipeline.postInitialise();
		
		ModRecipes.registerRecipes();
	}
	
	
}
