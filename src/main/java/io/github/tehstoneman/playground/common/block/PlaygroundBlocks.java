package io.github.tehstoneman.playground.common.block;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.tileentity.TileEntityLever;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PlaygroundBlocks
{
	public static Block	blockFactoryFrame;
	public static Block	blockModelTest;
	public static Block	blockLaserSource;
	public static Block	blockLaserTarget;
	public static Block	blockDigitalMiner;

	public static Block	blockLever;

	public static void RegisterBlocks()
	{
		// blockFactoryFrame = new BlockFactoryFrame( Material.IRON ).setUnlocalizedName( ModInfo.MODID + ".factoryFrame" );
		// blockFactoryFrame.setRegistryName( "factoryframe" );
		// GameRegistry.register( blockFactoryFrame );

		// blockModelTest = new BlockModelTest( Material.WOOD ).setUnlocalizedName( ModInfo.MODID + ".modelTest" );
		// blockModelTest.setRegistryName( "modelTest" );
		// GameRegistry.register( blockModelTest );

		// blockLaserSource = new BlockLaserSource( Material.WOOD ).setUnlocalizedName( ModInfo.MODID + ".laserSource" );
		// blockLaserSource.setRegistryName( "laserSource" );
		// GameRegistry.register( blockLaserSource );
		// blockLaserTarget = new BlockLaserTarget( Material.WOOD ).setUnlocalizedName( ModInfo.MODID + ".laserTarget" );
		// blockLaserTarget.setRegistryName( "LaserTarget" );
		// GameRegistry.register( blockLaserTarget );

		// blockDigitalMiner = new BlockDigitalMiner().setUnlocalizedName( ModInfo.MODID + ".digital_miner" );
		// blockDigitalMiner.setRegistryName( "digital_miner" );
		// GameRegistry.register( blockDigitalMiner );

		blockLever = new BlockLever().setUnlocalizedName( ModInfo.MODID + ".lever" );
		blockLever.setRegistryName( "lever" );
		GameRegistry.register( blockLever );
		GameRegistry.register( new ItemBlock( blockLever ).setRegistryName( blockLever.getRegistryName() ) );

		GameRegistry.registerTileEntity( TileEntityLever.class, BlockLever.NAME );
	}
}
