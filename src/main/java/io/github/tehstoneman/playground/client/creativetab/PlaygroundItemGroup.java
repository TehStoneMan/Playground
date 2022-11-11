package io.github.tehstoneman.playground.client.creativetab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class PlaygroundItemGroup extends CreativeModeTab
{
	public PlaygroundItemGroup()
	{
		super( "playground" );
	}

	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack( Items.BELL );
	}
}
