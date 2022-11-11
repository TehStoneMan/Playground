package io.github.tehstoneman.playground;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tehstoneman.playground.client.creativetab.PlaygroundItemGroup;
import io.github.tehstoneman.playground.config.PlaygroundConfig;
import io.github.tehstoneman.playground.network.ModNetwork;
import io.github.tehstoneman.playground.world.item.PlaygroundItems;
import io.github.tehstoneman.playground.world.level.block.PlaygroundBlocks;
import io.github.tehstoneman.playground.world.level.fluid.PlaygroundFluids;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod( ModInfo.MOD_ID )
public class Playground
{
	// Directly reference a log4j logger.
	public static final Logger			LOGGER				= LogManager.getLogger();
	public static final CreativeModeTab	CREATIVE_MODE_TAB	= new PlaygroundItemGroup();

	public static SimpleChannel network = ModNetwork.getNetworkChannel();

	public static Random RANDOM;

	public Playground()
	{
		// Initialize random numbers
		RANDOM = new Random();

		// Load configuration options
		PlaygroundConfig.register( ModLoadingContext.get() );

		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the setup method for modloading
		// FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );

		// Register ourselves for server and other game events we are interested in
		// MinecraftForge.EVENT_BUS.register( this );

		PlaygroundBlocks.REGISTERY.register( modEventBus );
		PlaygroundItems.REGISTERY.register( modEventBus );
		PlaygroundFluids.REGISTERY.register( modEventBus );
	}

	// private void setup( final FMLCommonSetupEvent event ) {}
}
