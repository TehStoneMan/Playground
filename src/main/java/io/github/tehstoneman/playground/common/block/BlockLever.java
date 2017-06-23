package io.github.tehstoneman.playground.common.block;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.tileentity.TileEntityLever;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLever extends Block implements ITileEntityProvider
{
	public static final String				NAME		= "lever";
	private static final AxisAlignedBB		BASE_AABB	= new AxisAlignedBB( 0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D );
	private static final PropertyDirection	FACING		= PropertyDirection.create( "facing", EnumFacing.Plane.HORIZONTAL );

	public BlockLever()
	{
		super( Material.WOOD );
	}

	@Override
	public ExtendedBlockState createBlockState()
	{
		return new ExtendedBlockState( this, new IProperty[] { FACING, Properties.StaticProperty },
				new IUnlistedProperty[] { Properties.AnimationProperty } );
	}

	@Override
	public IBlockState getActualState( IBlockState state, IBlockAccess world, BlockPos pos )
	{
		return state.withProperty( Properties.StaticProperty, true );
	}

	@Override
	public boolean onBlockActivated( World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem,
			EnumFacing facing, float hitX, float hitY, float hitZ )
	{
		if( world.isRemote )
		{
			final TileEntity te = world.getTileEntity( pos );
			if( te instanceof TileEntityLever )
				( (TileEntityLever)te ).click();
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity( World worldIn, int meta )
	{
		return new TileEntityLever();
	}

	@Override
	public AxisAlignedBB getBoundingBox( IBlockState state, IBlockAccess source, BlockPos pos )
	{
		return BASE_AABB;
	}

	@Override
	public boolean isFullCube( IBlockState state )
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube( IBlockState state )
	{
		return false;
	}

	@Override
	@SideOnly( Side.CLIENT )
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	@SideOnly( Side.CLIENT )
	public boolean shouldSideBeRendered( IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side )
	{
		return side.getAxis() != EnumFacing.Axis.Y;
	}

	@Override
	public IBlockState onBlockPlaced( World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
			EntityLivingBase placer )
	{
		return getDefaultState().withProperty( FACING, placer.getHorizontalFacing().getOpposite() );
	}

	@Override
	public IBlockState getStateFromMeta( int meta )
	{
		return getDefaultState().withProperty( FACING, EnumFacing.getFront( meta ) );
	}

	@Override
	public int getMetaFromState( IBlockState state )
	{
		return state.getValue( FACING ).getIndex();
	}
}
