package io.github.tehstoneman.playground.client.render;

import java.util.List;

import org.lwjgl.opengl.GL11;

import io.github.tehstoneman.playground.ModInfo;
import io.github.tehstoneman.playground.common.block.BlockLaserTarget;
import io.github.tehstoneman.playground.common.tileentity.TileEntityLaserSource;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class TileEntityLaserRenderer extends TileEntitySpecialRenderer< TileEntityLaserSource >
{
	public final ResourceLocation	LASER_BASE		= new ResourceLocation( ModInfo.MODID, "textures/particles/laser_base.png" );
	public final ResourceLocation	LASER_OVERLAY	= new ResourceLocation( ModInfo.MODID, "textures/particles/laser_overlay.png" );

	@Override
	public void renderTileEntityAt( TileEntityLaserSource te, double x, double y, double z, float partialTicks, int destroyStage )
	{
		final float red = 0.0f, green = 0.0f, blue = 1.0f;
        if (te.targetPos != null) {
            Vec3d start = new Vec3d(te.getPos().add( 0.5, 0.5, 0.5));
            Vec3d end = new Vec3d(te.targetPos.add( 0.5, 0.5, 0.5));
            //renderLaser(start, end, partialTicks, te.shouldLaserRender(), te.getLaserSegments(), te.getWorld().getTotalWorldTime());
        }
	}

    public void renderLaser( Vec3d start, Vec3d end, double partialTicks, double shouldLaserRender, List<TileEntityBeacon.BeamSegment> laserSegments, double totalWorldTime)
    {
        GlStateManager.alphaFunc(516, 0.1F);
        this.bindTexture(LASER_BASE);

        if (shouldLaserRender > 0.0D && laserSegments.size() > 0 )
        {
            GlStateManager.disableFog();
            int i = 0;
            
            for (int j = 0; j < laserSegments.size(); ++j)
            {
                TileEntityBeacon.BeamSegment tileentitybeacon$beamsegment = (TileEntityBeacon.BeamSegment)laserSegments.get(j);
                //renderBeamSegment(x, y, z, partialTicks, shouldLaserRender, totalWorldTime, i, tileentitybeacon$beamsegment.getHeight(), tileentitybeacon$beamsegment.getColors());
                i += tileentitybeacon$beamsegment.getHeight();
            }

            GlStateManager.enableFog();
        }
    }

	public void renderBeamSegment(double x, double y, double z, double partialTicks, double shouldBeamRender, List<TileEntityBeacon.BeamSegment> beamSegments, double totalWorldTime)
	{
		final double laserScale = 1.0;

		// save the transformation matrix and the rendering attributes, so that we can restore them after rendering. This
		// prevents us disrupting any vanilla TESR that render after ours.
		// For further information on rendering using the Tessellator, see
		// http://greyminecraftcoder.blogspot.co.at/2014/12/the-tessellator-and-worldrenderer-18.html
		GL11.glPushMatrix();

		GlStateManager.translate( x + 0.5, y + 0.5, z + 0.5 );

		GlStateManager.scale( laserScale, laserScale, laserScale );

		final Tessellator tessellator = Tessellator.getInstance();
		final VertexBuffer vertexBuffer = tessellator.getBuffer();

		bindTexture( LASER_BASE );
		//bindTexture( LASER_OVERLAY );
		//GlStateManager.glTexParameteri( 3553, 10242, 10497 );
		GlStateManager.disableLighting();
		//GlStateManager.disableCull();
		//GlStateManager.depthMask( false );
		this.setLightmapDisabled( true );
		//GlStateManager.enableBlend();
		//GlStateManager.blendFunc( GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE );
		//GlStateManager.glBlendEquation( blendEquation );
        //GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		//GlStateManager.alphaFunc( 516, 0.003921569F );

		final float red = 0.0f, green = 0.0f, blue = 1.0f;
		for( int ty = -5 ; ty <= 5 ; ty++ )
			for( int tz = -5 ; tz <= 5 ; tz++ )
				for( int tx = -5 ; tx <= 5 ; tx++ )
				{
					//BlockPos test = te.getPos().add( new Vec3i( tx, ty, tz ) );
					//Block block = te.getWorld().getBlockState( test ).getBlock();
					/*if( block instanceof BlockLaserTarget )
					{
						Vec3d start = new Vec3d(te.getPos().add( 0.5, 0.5, 0.5 ));
						Vec3d end = new Vec3d(test.add( 0.5, 0.5, 0.5 ));
						bindTexture( LASER_BASE );
						renderLaser( vertexBuffer, start, end, red, green, blue, 0.05);
						tessellator.draw();
						
						//bindTexture( LASER_OVERLAY );
						//renderLaser( vertexBuffer, start, end, 1.0f, 1.0f, 1.0f, 0.1);
						//tessellator.draw();
		//GlStateManager.color( red, green, blue ); // change the rendering colour

		//vertexBuffer.begin( GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX );
		//addGemVertices( vertexBuffer );
					}*/
				}

		//bindTexture( LASER_OVERLAY );
		//GlStateManager.color( 1.0f, 1.0f, 1.0f );
		//GlStateManager.blendFunc( GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE );
		//vertexBuffer.begin( GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX );
		//addGemVertices( vertexBuffer );
		//tessellator.draw();

		GL11.glPopMatrix();
	}

	// this should be true for tileentities which render globally (no render bounding box), such as beacons.
	@Override
	public boolean isGlobalRenderer( TileEntityLaserSource te )
	{
		return false;
	}

	// add the vertices for drawing the gem. Generated using a model builder and pasted manually because the object model
	// loader wasn't implemented at the time I wrote this example...
	private void addGemVertices( VertexBuffer worldrenderer )
	{
		final double[][] vertexTable = { { -0.5, 0.000,  0.5, 0.000, 0.000 },
										 {  0.5, 0.000,  0.5, 1.000, 0.000 },
										 {  0.5, 1.000,  0.5, 1.000, 1.000 },
										 { -0.5, 1.000,  0.5, 0.000, 1.000 },

										 { -0.5, 0.000, -0.5, 0.000, 0.000 },
										 { -0.5, 0.000,  0.5, 1.000, 0.000 },
										 { -0.5, 1.000,  0.5, 1.000, 1.000 },
										 { -0.5, 1.000, -0.5, 0.000, 1.000 },
										 
										 {  0.5, 0.000, -0.5, 0.000, 0.000 },
										 { -0.5, 0.000, -0.5, 1.000, 0.000 },
										 { -0.5, 1.000, -0.5, 1.000, 1.000 },
										 {  0.5, 1.000, -0.5, 0.000, 1.000 },

										 {  0.5, 0.000,  0.5, 0.000, 0.000 },
										 {  0.5, 0.000, -0.5, 1.000, 0.000 },
										 {  0.5, 1.000, -0.5, 1.000, 1.000 },
										 {  0.5, 1.000,  0.5, 0.000, 1.000 }};

		for( final double[] vertex : vertexTable )
			worldrenderer.pos( vertex[0], vertex[1], vertex[2] ).tex( vertex[3], vertex[4] ).endVertex();
	}
	
	private void renderLaser( VertexBuffer vertexBuffer, Vec3d start, Vec3d end, float red, float green, float blue, double scale )
	{
		Vec3d targetOffset = end.subtract( start );
		double distance = targetOffset.lengthVector();
		Vec3d TargetDir = targetOffset.normalize();

        float f5 = (float)Math.acos(TargetDir.yCoord);
        float f6 = (float)Math.atan2(TargetDir.zCoord, TargetDir.xCoord);
        GlStateManager.rotate((((float)Math.PI / 2F) + -f6) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f5 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);

		GlStateManager.color( red, green, blue ); // change the rendering colour

		vertexBuffer.begin( GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX );
		addGemVertices( vertexBuffer );
		GlStateManager.scale( scale, distance, scale );
	}
}
