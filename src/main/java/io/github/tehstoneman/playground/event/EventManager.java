package io.github.tehstoneman.playground.event;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.Playground;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber( modid = ModInfo.MOD_ID, bus = Bus.MOD )
public class EventManager
{
	@SubscribeEvent
	public static void onCommonSetup( FMLCommonSetupEvent event )
	{}

	@SubscribeEvent
	public static void onRegisterItems( RegistryEvent.Register< Item > event )
	{
		final IForgeRegistry< Item > registry = event.getRegistry();
	}

	private static Properties defaultItemProperties()
	{
		return new Properties().group( Playground.ITEM_GROUP );
	}
}
