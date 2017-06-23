package io.github.tehstoneman.playground.common.block;

import java.util.Random;
import java.util.logging.Logger;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.tileentity.TileEntityLaserSource;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLaserSource extends Block implements ITileEntityProvider
{
	public BlockLaserSource( Material materialIn )
	{
		super( materialIn );
	}

	@Override
	public TileEntity createNewTileEntity( World worldIn, int meta )
	{
		return new TileEntityLaserSource();
	}
	
    /*@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		Logger.getLogger( ModInfo.MODID ).info( "isRemote " + worldIn.isRemote );
		for( int y = -5 ; y <= 5 ; y++ )
			for( int z = -5 ; z <= 5 ; z++ )
				for( int x = -5 ; x <= 5 ; x++ )
				{
					BlockPos test = pos.add( new Vec3i( x, y, z ) );
					Block block = worldIn.getBlockState( test ).getBlock();
					if( block instanceof BlockLaserTarget )
					{
						double distance = pos.getDistance( test.getX(), test.getY(), test.getZ() );
						Vec3d vector = new Vec3d( x, y, z ).normalize();
						for( double i = 0 ; i < distance ; i += 0.25D )
						{
							Vec3d offset = vector.scale( i );
							worldIn.spawnParticle( EnumParticleTypes.SMOKE_NORMAL, pos.getX() + offset.xCoord + 0.5D, pos.getY() + offset.yCoord + 0.5D, pos.getZ() + offset.zCoord + 0.5D, 0.0D, 0.0D, 0.0D, 0 );
						}
					}
				}
    }*/

    /*@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
		for( int y = -5 ; y <= 5 ; y++ )
			for( int z = -5 ; z <= 5 ; z++ )
				for( int x = -5 ; x <= 5 ; x++ )
				{
					BlockPos test = pos.add( new Vec3i( x, y, z ) );
					Block block = worldIn.getBlockState( test ).getBlock();
					if( block instanceof BlockLaserTarget )
					{
						double distance = pos.getDistance( test.getX(), test.getY(), test.getZ() );
						Vec3d vector = new Vec3d( x, y, z ).normalize();
						for( double i = 0 ; i < distance ; i += 0.25D )
						{
							Vec3d offset = vector.scale( i );
							worldIn.spawnParticle( EnumParticleTypes.SMOKE_NORMAL, pos.getX() + offset.xCoord + 0.5D, pos.getY() + offset.yCoord + 0.5D, pos.getZ() + offset.zCoord + 0.5D, 0.0D, 0.0D, 0.0D, 0 );
						}
					}
				}
    }*/
}
