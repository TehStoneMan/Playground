package io.github.tehstoneman.playground.common.block;

import io.github.tehstoneman.playground.common.tileentity.TileEntityLaserTarget;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLaserTarget extends Block implements ITileEntityProvider
{
	public BlockLaserTarget( Material materialIn )
	{
		super( materialIn );
	}

	@Override
	public TileEntity createNewTileEntity( World worldIn, int meta )
	{
		return new TileEntityLaserTarget();
	}
}
