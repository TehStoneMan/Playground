package io.github.tehstoneman.playground.common.block;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.fluid.PlaygroundFluids;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaygroundBlocks
{
	public static final DeferredRegister< Block >		BLOCK_REGISTER	= DeferredRegister.create( ForgeRegistries.BLOCKS, ModInfo.MOD_ID );

	public static RegistryObject< FlowingFluidBlock >	LIQUID_FART		= BLOCK_REGISTER.register( "liquid_fart",
			() -> new FlowingFluidBlock( PlaygroundFluids.LIQUID_FART, AbstractBlock.Properties.copy( Blocks.WATER ) ) );
}
