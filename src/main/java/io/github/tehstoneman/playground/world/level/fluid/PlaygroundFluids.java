package io.github.tehstoneman.playground.world.level.fluid;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaygroundFluids
{
	public static final DeferredRegister< Fluid > REGISTERY = DeferredRegister.create( ForgeRegistries.FLUIDS, ModInfo.MOD_ID );

	/*
	 * public static RegistryObject< ForgeFlowingFluid > LIQUID_FART = REGISTERY.register( "liquid_fart",
	 * () -> new ForgeFlowingFluid.Source( LiquidFartFluid.PROPERTIES ) );
	 */
	/*
	 * public static RegistryObject< ForgeFlowingFluid > FLOWING_FART = REGISTERY.register( "flowing_fart",
	 * () -> new ForgeFlowingFluid.Flowing( LiquidFartFluid.PROPERTIES ) );
	 */
}
