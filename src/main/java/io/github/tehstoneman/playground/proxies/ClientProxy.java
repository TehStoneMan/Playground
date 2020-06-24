package io.github.tehstoneman.playground.proxies;

import com.google.common.collect.ImmutableMap;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.event.EventManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		super.preInit();

		OBJLoader.INSTANCE.addDomain( ModInfo.MOD_ID );
		MinecraftForge.EVENT_BUS.register( new EventManager() );

		final ModelResourceLocation itemModelResourceLocation;
	}

	@Override
	public void Init()
	{
		super.Init();
	}

	@Override
	public void postInit()
	{
		super.postInit();
	}

	@Override
	public IAnimationStateMachine load( ResourceLocation resourceLocation, ImmutableMap< String, ITimeValue > parameters )
	{
		return ModelLoaderRegistry.loadASM( resourceLocation, parameters );
	}
}
