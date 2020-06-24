package io.github.tehstoneman.playground.common.fluid;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaygroundFluids
{
	public static final DeferredRegister< Fluid >		FLUID_REGISTER	= new DeferredRegister<>( ForgeRegistries.FLUIDS, ModInfo.MOD_ID );

	public static RegistryObject< ForgeFlowingFluid >	LIQUID_FART		= FLUID_REGISTER.register( "liquid_fart",
			() -> new ForgeFlowingFluid.Source( FluidFart.properties ) );
	public static RegistryObject< ForgeFlowingFluid >	FLOWING_FART	= FLUID_REGISTER.register( "flowing_fart",
			() -> new ForgeFlowingFluid.Flowing( FluidFart.properties ) );
}
