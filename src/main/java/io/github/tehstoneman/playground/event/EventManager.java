package io.github.tehstoneman.playground.event;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventManager
{
	@SubscribeEvent
	public void StitcherEventPre( TextureStitchEvent.Pre event )
	{
		ResourceLocation PARTICLE_LASER = new ResourceLocation( ModInfo.MODID, "particles/laser" );
		event.getMap().registerSprite( PARTICLE_LASER );
	}
}
