package io.github.tehstoneman.playground.proxies;

import com.google.common.collect.ImmutableMap;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.client.render.TileEntityLeverRenderer;
import io.github.tehstoneman.playground.common.block.PlaygroundBlocks;
import io.github.tehstoneman.playground.common.tileentity.TileEntityLever;
import io.github.tehstoneman.playground.event.EventManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		super.preInit();

		OBJLoader.INSTANCE.addDomain( ModInfo.MODID );
		MinecraftForge.EVENT_BUS.register( new EventManager() );

		final ModelResourceLocation itemModelResourceLocation;

		ModelLoader.setCustomModelResourceLocation( Item.getItemFromBlock( PlaygroundBlocks.blockLever ), 0,
				new ModelResourceLocation( PlaygroundBlocks.blockLever.getRegistryName(), "inventory" ) );

		// ItemBlock itemBlockFactoryFrame = new ItemBlock( PlaygroundBlocks.blockFactoryFrame );
		// GameRegistry.register( itemBlockFactoryFrame.setRegistryName( PlaygroundBlocks.blockFactoryFrame.getRegistryName() ) );
		// itemModelResourceLocation = new ModelResourceLocation( itemBlockFactoryFrame.getRegistryName(), "inventory" );
		// ModelLoader.setCustomModelResourceLocation( itemBlockFactoryFrame, 0, itemModelResourceLocation );

		// ItemBlock itemBlockModelTest = new ItemBlock( PlaygroundBlocks.blockModelTest );
		// GameRegistry.register( itemBlockModelTest.setRegistryName( PlaygroundBlocks.blockModelTest.getRegistryName() ) );
		// itemModelResourceLocation = new ModelResourceLocation( itemBlockModelTest.getRegistryName(), "inventory" );
		// ModelLoader.setCustomModelResourceLocation( itemBlockModelTest, 0, itemModelResourceLocation );

		// ItemBlock itemBlockLaserSource = new ItemBlock( PlaygroundBlocks.blockLaserSource );
		// GameRegistry.register( itemBlockLaserSource.setRegistryName( PlaygroundBlocks.blockLaserSource.getRegistryName() ) );
		// itemModelResourceLocation = new ModelResourceLocation( itemBlockLaserSource.getRegistryName(), "inventory" );
		// ModelLoader.setCustomModelResourceLocation( itemBlockLaserSource, 0, itemModelResourceLocation );

		// ItemBlock itemBlockLaserTarget = new ItemBlock( PlaygroundBlocks.blockLaserTarget );
		// GameRegistry.register( itemBlockLaserTarget.setRegistryName( PlaygroundBlocks.blockLaserTarget.getRegistryName() ) );
		// itemModelResourceLocation = new ModelResourceLocation( itemBlockLaserTarget.getRegistryName(), "inventory" );
		// ModelLoader.setCustomModelResourceLocation( itemBlockLaserTarget, 0, itemModelResourceLocation );
	}

	@Override
	public void Init()
	{
		super.Init();
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaserSource.class, new TileEntityLaserRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLever.class, new TileEntityLeverRenderer());
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
