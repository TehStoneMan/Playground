package io.github.tehstoneman.playground.client;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( modid = ModInfo.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ClientSetup
{
	/*
	 * @SubscribeEvent
	 * public static void init( final FMLClientSetupEvent event )
	 * {
	 * for( final RegistryObject< Fluid > fluid : PlaygroundFluids.REGISTERY.getEntries() )
	 * ItemBlockRenderTypes.setRenderLayer( fluid.get(), RenderType.translucent() );
	 * }
	 */
}
