package io.github.tehstoneman.playground.world.level.block;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaygroundBlocks
{
	public static final DeferredRegister< Block > REGISTERY = DeferredRegister.create( ForgeRegistries.BLOCKS, ModInfo.MOD_ID );

	/*
	 * public static final RegistryObject< LiquidBlock > LIQUID_FART = REGISTERY.register( "liquid_fart",
	 * () -> new LiquidBlock( PlaygroundFluids.LIQUID_FART, Block.Properties.of( LiquidFartFluid.MATERIAL_FART ) ) );
	 */
}
