package io.github.tehstoneman.playground.client.creativetab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class PlaygroundItemGroup extends ItemGroup
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
