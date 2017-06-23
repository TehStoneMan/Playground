package io.github.tehstoneman.playground.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFactoryFrame extends Block
{
	protected BlockFactoryFrame(Material material)
	{
		super( material );
	}

	/*@Override
	public boolean isOpaqueCube()
	{
		return false;
	}*/

	@SideOnly( Side.CLIENT )
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	/*
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        IBlockState nextBlockstate = worldIn.getBlockState(pos.offset(side.getOpposite()));
        Block nextBlock = nextBlockstate.getBlock();
        
        if (block == this)
        {
            return false;
        }

        return super.shouldSideBeRendered(worldIn, pos, side);
    }
    */
}
