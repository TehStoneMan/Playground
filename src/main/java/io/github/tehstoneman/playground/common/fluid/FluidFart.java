package io.github.tehstoneman.playground.common.fluid;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.block.PlaygroundBlocks;
import io.github.tehstoneman.playground.common.item.PlaygroundItems;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class FluidFart extends ForgeFlowingFluid
{
	public static ResourceLocation			stillTexture	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_still" );
	public static ResourceLocation			flowingTexture	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_flowing" );
	public static FluidAttributes.Builder	builder			= FluidAttributes.builder( stillTexture, flowingTexture ).color( 0xF06D7A26 ).density( -100 ).gaseous();
	public static Properties				properties		= new Properties( PlaygroundFluids.LIQUID_FART, PlaygroundFluids.FLOWING_FART, builder )
			.bucket( PlaygroundItems.FART_BUCKET ).block( PlaygroundBlocks.LIQUID_FART );

	protected FluidFart()
	{
		super( properties );
	}
}
