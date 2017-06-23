package io.github.tehstoneman.playground.common.item;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.block.PlaygroundBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PlaygroundItems
{
	public static ItemJetpack itemJetpack;

	public static void RegisterItems()
	{
		//itemJetpack = (ItemJetpack)new ItemJetpack().setUnlocalizedName( ModInfo.MODID + ".jetpack" );
		//GameRegistry.register( itemJetpack.setRegistryName( "jetpack" ) );
	}
}
