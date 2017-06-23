package io.github.tehstoneman.playground.common.tileentity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import io.github.tehstoneman.playground.common.block.BlockLaserTarget;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon.BeamSegment;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityLaserSource extends TileEntity implements ITickable
{
	private final int			ticks	= 0;
	public BlockPos				targetPos;
	Random						rand	= new Random();
	public List< BeamSegment >	laserSegments;

	private void findTarget()
	{
		final BlockPos min = getPos().add( new BlockPos( -5, -5, -5 ) );
		final BlockPos max = getPos().add( new BlockPos( 5, 5, 5 ) );

		final List< BlockPos > targetPoses = new LinkedList<>();
		for( final BlockPos pos : BlockPos.getAllInBox( min, max ) )
			if( worldObj.getBlockState( pos ).getBlock() instanceof BlockLaserTarget )
				targetPoses.add( pos );

		if( targetPoses.isEmpty() )
			return;

		targetPos = targetPoses.get( worldObj.rand.nextInt( targetPoses.size() ) );
	}

	private TileEntityLaserTarget getTarget()
	{
		if( targetPos != null )
		{
			final TileEntity tile = worldObj.getTileEntity( targetPos );
			if( tile instanceof TileEntityLaserTarget )
			{
				final TileEntityLaserTarget target = (TileEntityLaserTarget)tile;
				return target;
			}
			else
				return null;
		}
		else
			return null;
	}

	@Override
	public void update()
	{
		if( !worldObj.isRemote )
			return;

		if( getTarget() == null )
			targetPos = null;

		if( ticks % ( 10 + worldObj.rand.nextInt( 20 ) ) == 0 || getTarget() == null )
			findTarget();

		/*
		 * for( int y = -5; y <= 5; y++ )
		 * for( int z = -5; z <= 5; z++ )
		 * for( int x = -5; x <= 5; x++ )
		 * {
		 * final BlockPos test = pos.add( new Vec3i( x, y, z ) );
		 * final Block block = worldObj.getBlockState( test ).getBlock();
		 * if( block instanceof BlockLaserTarget )
		 * {
		 * final double distance = pos.getDistance( test.getX(), test.getY(), test.getZ() );
		 * final Vec3d vector = new Vec3d( x, y, z ).normalize();
		 * for( double i = 0; i < distance; i += 0.25D )
		 * {
		 * final Vec3d offset = vector.scale( i + rand.nextDouble() * 0.25 );
		 * final ParticleLaser newParticle = new ParticleLaser( worldObj, pos.getX() + offset.xCoord + 0.5D,
		 * pos.getY() + offset.yCoord + 0.5D, pos.getZ() + offset.zCoord + 0.5D, 1.0f, 1.0f, 1.0f );
		 * // Minecraft.getMinecraft().effectRenderer.addEffect( newParticle );
		 * }
		 * }
		 * }
		 */
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		AxisAlignedBB boundingBox = super.getRenderBoundingBox();

		if( targetPos != null )
		{
			BlockPos min = getPos();
			BlockPos max = getPos();

			min = new BlockPos( Math.min( min.getX(), targetPos.getX() ), Math.min( min.getY(), targetPos.getY() ),
					Math.min( min.getZ(), targetPos.getZ() ) );
			max = new BlockPos( Math.max( max.getX(), targetPos.getX() ), Math.max( max.getY(), targetPos.getY() ),
					Math.max( max.getZ(), targetPos.getZ() ) );

			boundingBox = new AxisAlignedBB( min, max.add( 1, 1, 1 ) );
		}

		return boundingBox;
	}

	public double shouldLaserRender()
	{
		return 1.0;
	}

	public List< BeamSegment > getLaserSegments()
	{
		return this.laserSegments;
	}
}
