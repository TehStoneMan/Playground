package io.github.tehstoneman.playground;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tehstoneman.playground.client.creativetab.PlaygroundItemGroup;
import io.github.tehstoneman.playground.proxies.ModNetwork;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod( ModInfo.MOD_ID )
public class Playground
{
	// Directly reference a log4j logger.
	public static final Logger		LOGGER		= LogManager.getLogger();
	public static final ItemGroup	ITEM_GROUP	= new PlaygroundItemGroup();

	public static SimpleChannel		network		= ModNetwork.getNetworkChannel();

	public static Random			RANDOM;

	public Playground()
	{
		// Initialize random numbers
		RANDOM = new Random();

		// final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the setup method for modloading
		// FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );

		// Register ourselves for server and other game events we are interested in
		// MinecraftForge.EVENT_BUS.register( this );

		// PlaygroundBlocks.BLOCK_REGISTER.register( modEventBus );
		// PlaygroundItems.ITEM_REGISTER.register( modEventBus );
		// PlaygroundFluids.FLUID_REGISTER.register( modEventBus );
	}

	// private void setup( final FMLCommonSetupEvent event ) {}
}
