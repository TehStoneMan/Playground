package io.github.tehstoneman.playground.proxies;

import com.google.common.collect.ImmutableMap;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.client.creativetab.PlaygroundTab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class CommonProxy
{
	public PlaygroundTab playgroundTab;

	public void preInit()
	{
		playgroundTab = new PlaygroundTab( ModInfo.MODID );

		// PlaygroundBlocks.RegisterBlocks();
		// PlaygroundItems.RegisterItems();

		// GameRegistry.registerTileEntity( TileEntityLaserSource.class, "laserSource" );
		// GameRegistry.registerTileEntity( TileEntityLaserTarget.class, "laserTarget" );
	}

	public void Init()
	{}

	public void postInit()
	{}

	public IAnimationStateMachine load( ResourceLocation resourceLocation, ImmutableMap< String, ITimeValue > parameters )
	{
		return null;
	}
}
