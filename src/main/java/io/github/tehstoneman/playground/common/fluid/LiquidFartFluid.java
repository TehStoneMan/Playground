package io.github.tehstoneman.playground.common.fluid;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.block.PlaygroundBlocks;
import io.github.tehstoneman.playground.common.item.PlaygroundItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class LiquidFartFluid extends ForgeFlowingFluid
{
	public static final ResourceLocation		STILL_TEXTURE	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_still" );
	public static final ResourceLocation		FLOWING_TEXTURE	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_flowing" );

	public static final Material				MATERIAL_FART	= new Material.Builder( MaterialColor.TERRACOTTA_GREEN ).noCollider().nonSolid()
			.replaceable().liquid().build();

	public static final FluidAttributes.Builder	BUILDER			= FluidAttributes.builder( STILL_TEXTURE, FLOWING_TEXTURE ).color( 0xF06D7A26 )
			.density( -100 ).gaseous();
	public static final Properties				PROPERTIES		= new Properties( PlaygroundFluids.LIQUID_FART, PlaygroundFluids.FLOWING_FART,
			BUILDER ).bucket( PlaygroundItems.FART_BUCKET ).block( PlaygroundBlocks.LIQUID_FART );

	protected LiquidFartFluid( Properties properties )
	{
		super( properties );
	}
}
