package io.github.tehstoneman.playground.client.creativetab;

import java.util.List;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.block.PlaygroundBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class PlaygroundTab extends CreativeTabs
{

	public PlaygroundTab( String label )
	{
		super(label);
	}

	@Override
	public Item getTabIconItem()
	{
		//return Item.getItemFromBlock( new PlaygroundBlocks().blockFactoryFrame );
		return Items.CAKE;
	}

	@Override
	public void displayAllRelevantItems( List itemsToShowOnTab )
	{
		for( final Object itemObject : Item.REGISTRY )
		{
			final Item item = (Item)itemObject;
			if( item != null )
				if( item.getUnlocalizedName().contains( ModInfo.MODID ) )
					item.getSubItems( item, this, itemsToShowOnTab );
		}
	}
}
