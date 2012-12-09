package ninjapancakes87.morestuff.common;

import net.minecraft.src.Block;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "modid", name = "More Stuff", version = "Alpha 0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class mod_MoreStuff {

	@Instance("modid")
	public static mod_MoreStuff instance;
	
	@SidedProxy(clientSide="ninjapancakes87.morestuff.client.morestuffClientProxy", serverSide="ninjapancakes87.morestuff.common.MoreStuffCommonProxy")
	public static MoreStuffCommonProxy proxy;
	
	public static Block ZirconOre;
	public static Block CorundumOre;
	
	public static Item Ruby;
	public static Item Sapphire;
	public static Item Corundum;
	public static Item Zircon;
	public static Item RawZircon;
	
	public static int ZirconBlockID;
	public static int CorundumBlockID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) 
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		ZirconBlockID = config.getBlock("myFirstBlock", 538).getInt();
		CorundumBlockID = config.getBlock("myFirstBlock", 539).getInt();
			
		config.save();
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{

		InitBlocksAndItems();
		
		InitLanguageRegistry();
		
		InitEverythingElse();
		
		InitRecipes();
			
		proxy.registerRenderThings();
				
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) 
	{

	}
	private void InitBlocksAndItems(){
		ZirconOre = (new BlockZO(ZirconBlockID, 1)).setBlockName("ZO");
		CorundumOre = (new BlockCO(CorundumBlockID, 0)).setBlockName("CO");
		
		Ruby = (new ItemR(900)).setIconIndex(0).setItemName("UnreadableRuby");
		Sapphire = (new ItemR(901)).setIconIndex(1).setItemName("UnreadableSapphire");
		Corundum = (new ItemR(902)).setIconIndex(2).setItemName("UnreadableCorundum");
		Zircon = (new ItemR(903)).setIconIndex(4).setItemName("UnreadableZircon");
		RawZircon = (new ItemR(904)).setIconIndex(3).setItemName("UnreadableRawness");
	}
	private void InitLanguageRegistry(){
		LanguageRegistry.addName(ZirconOre, "Zircon Ore");
		LanguageRegistry.addName(CorundumOre, "Corundum Ore");
		
		LanguageRegistry.addName(Ruby, "Ruby");
		LanguageRegistry.addName(Sapphire, "Sapphire");
		LanguageRegistry.addName(Corundum, "Corundum");
		LanguageRegistry.addName(Zircon, "Zircon");
		LanguageRegistry.addName(RawZircon, "Raw Zircon");
	}
	private void InitRecipes(){
		 GameRegistry.addSmelting(CorundumOre.blockID, new ItemStack(Corundum), 1F);
		 GameRegistry.addSmelting(RawZircon.shiftedIndex, new ItemStack(Zircon), 0.5F);
		 }	
	private void InitEverythingElse(){
		MinecraftForge.setBlockHarvestLevel(ZirconOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(CorundumOre, "pickaxe", 3);
		
		GameRegistry.registerBlock(ZirconOre);
		GameRegistry.registerBlock(CorundumOre);
		
		DungeonHooks.addDungeonLoot(new ItemStack(Corundum), 100, 1, 3);
		
		GameRegistry.registerWorldGenerator(new WorldgeneratorOres());
	}
	
}
