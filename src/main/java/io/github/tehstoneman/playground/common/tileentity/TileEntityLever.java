package io.github.tehstoneman.playground.common.tileentity;

import com.google.common.collect.ImmutableMap;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.Playground;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.TimeValues.VariableValue;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class TileEntityLever extends TileEntity
{
	private final IAnimationStateMachine	asm;
	private final VariableValue				clickTime	= new VariableValue( Float.NEGATIVE_INFINITY );

	public TileEntityLever()
	{
		asm = Playground.proxy.load( new ResourceLocation( ModInfo.MODID, "asms/block/lever.json" ), ImmutableMap.of( "click_time", clickTime ) );
	}

	@Override
	public boolean hasCapability( Capability< ? > capability, EnumFacing facing )
	{
		return capability == CapabilityAnimation.ANIMATION_CAPABILITY || super.hasCapability( capability, facing );
	}

	@Override
	public <T> T getCapability( Capability< T > capability, EnumFacing facing )
	{
		if( capability == CapabilityAnimation.ANIMATION_CAPABILITY )
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast( asm );
		return super.getCapability( capability, facing );
	}

	public void handleEvents( float time, Iterable< Event > pastEvents )
	{}

	public void click()
	{
		if( asm != null )
			if( asm.currentState().equals( "open" ) )
			{
				final float time = Animation.getWorldTime( getWorld(), Animation.getPartialTickTime() );
				clickTime.setValue( time );
				asm.transition( "closing" );
			}
			else
				if( asm.currentState().equals( "closed" ) )
				{
					final float time = Animation.getWorldTime( getWorld(), Animation.getPartialTickTime() );
					clickTime.setValue( time );
					asm.transition( "opening" );
				}
	}
}
