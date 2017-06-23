package io.github.tehstoneman.playground.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockModelTest extends Block
{
	public BlockModelTest( Material materialIn )
	{
		super( materialIn );
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
}
