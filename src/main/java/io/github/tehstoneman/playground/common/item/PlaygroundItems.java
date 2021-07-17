package io.github.tehstoneman.playground.common.item;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.Playground;
import io.github.tehstoneman.playground.common.fluid.PlaygroundFluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@ObjectHolder( ModInfo.MOD_ID )
public class PlaygroundItems
{
	public static final DeferredRegister< Item >		ITEM_REGISTER	= DeferredRegister.create( ForgeRegistries.ITEMS, ModInfo.MOD_ID );

	public static RegistryObject<BucketItem>	FART_BUCKET		= ITEM_REGISTER.register( "fart_bucket",
			() -> new  BucketItem( PlaygroundFluids.LIQUID_FART,
					new Item.Properties().craftRemainder( Items.BUCKET ).stacksTo( 1 ).tab( Playground.ITEM_GROUP ) ));
}