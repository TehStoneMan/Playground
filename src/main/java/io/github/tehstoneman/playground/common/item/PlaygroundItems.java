package io.github.tehstoneman.playground.common.item;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.Playground;
import io.github.tehstoneman.playground.common.fluid.FluidFart;
import io.github.tehstoneman.playground.common.fluid.PlaygroundFluids;
import net.minecraft.block.Block;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

//@ObjectHolder( ModInfo.MOD_ID )
public class PlaygroundItems
{
	public static final DeferredRegister< Item >		ITEM_REGISTER	= new DeferredRegister<>( ForgeRegistries.ITEMS, ModInfo.MOD_ID );

	public static RegistryObject<BucketItem>	FART_BUCKET		= ITEM_REGISTER.register( "fart_bucket",
			() -> new  BucketItem( PlaygroundFluids.LIQUID_FART,
					new Item.Properties().containerItem( Items.BUCKET ).maxStackSize( 1 ).group( Playground.ITEM_GROUP ) ));
}