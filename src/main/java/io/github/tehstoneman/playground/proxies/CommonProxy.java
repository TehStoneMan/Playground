package io.github.tehstoneman.playground.proxies;

import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class CommonProxy
{
	public void preInit()
	{

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
