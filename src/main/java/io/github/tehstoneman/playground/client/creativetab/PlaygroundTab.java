package io.github.tehstoneman.playground.client.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PlaygroundTab extends CreativeTabs
{

	public PlaygroundTab( String label )
	{
		super( label );
	}

	@Override
	public ItemStack getTabIconItem()
	{
		// return Item.getItemFromBlock( new PlaygroundBlocks().blockFactoryFrame );
		return new ItemStack( Items.CAKE );
	}
}
