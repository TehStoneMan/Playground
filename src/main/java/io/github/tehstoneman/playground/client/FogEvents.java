package io.github.tehstoneman.playground.client;

// @Mod.EventBusSubscriber( modid = ModInfo.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE )
public class FogEvents
{
	/*
	 * @SubscribeEvent
	 * public void onFogDinsityEvent( FogDensity event )
	 * {
	 * final Camera info = event.getCamera();
	 * final Entity entity = info.getEntity();
	 * if( entity instanceof ClientPlayerEntity )
	 * {
	 * final BlockState fluid = info.getBlockAtCamera();
	 * Playground.LOGGER.info( "---- " + fluid + " ----" );
	 * if( fluid.getBlock().isSame( PlaygroundBlocks.LIQUID_FART.get() ) )
	 * {
	 * event.setDensity( 0.5f );
	 * event.setCanceled( true ); // must cancel event for event handler to take effect
	 * }
	 * }
	 * }
	 */
}
