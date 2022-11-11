package io.github.tehstoneman.playground.world.item;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlaygroundItems
{
	public static final DeferredRegister< Item > REGISTERY = DeferredRegister.create( ForgeRegistries.ITEMS, ModInfo.MOD_ID );

	/*
	 * public static RegistryObject< BucketItem > FART_BUCKET = REGISTERY.register( "fart_bucket",
	 * () -> new BucketItem( PlaygroundFluids.LIQUID_FART,
	 * new Item.Properties().craftRemainder( Items.BUCKET ).stacksTo( 1 ).tab( Playground.CREATIVE_MODE_TAB ) ) );
	 */
}