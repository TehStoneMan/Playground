package io.github.tehstoneman.playground.world.level.fluid;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class LiquidFartFluid extends ForgeFlowingFluid
{
	public static final ResourceLocation	STILL_TEXTURE	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_still" );
	public static final ResourceLocation	FLOWING_TEXTURE	= new ResourceLocation( ModInfo.MOD_ID, "block/liquid_fart_flowing" );

	public static final Material MATERIAL_FART = new Material.Builder( MaterialColor.TERRACOTTA_GREEN ).noCollider().nonSolid().replaceable().liquid()
		.build();

	/*
	 * public static final FluidAttributes.Builder BUILDER = FluidAttributes.builder( STILL_TEXTURE, FLOWING_TEXTURE ).color( 0xFF6D7A26 )
	 * .density( -100 ).gaseous();
	 */
	/*
	 * public static final Properties PROPERTIES = new Properties( PlaygroundFluids.LIQUID_FART, PlaygroundFluids.FLOWING_FART, BUILDER )
	 * .bucket( PlaygroundItems.FART_BUCKET ).block( PlaygroundBlocks.LIQUID_FART );
	 */

	protected LiquidFartFluid( Properties properties )
	{
		super( properties );
		// this.isEntityInside( state, world, pos, entity, yToTest, tag, testingHead )
	}
}
