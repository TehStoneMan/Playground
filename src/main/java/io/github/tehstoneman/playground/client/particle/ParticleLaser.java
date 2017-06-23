package io.github.tehstoneman.playground.client.particle;

import io.github.tehstoneman.playground.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleLaser extends Particle
{
	public final ResourceLocation PARTICLE_LASER = new ResourceLocation( ModInfo.MODID, "particles/laser" );

	public ParticleLaser( World worldIn, double posXIn, double posYIn, double posZIn, float red, float green, float blue )
	{
		super( worldIn, posXIn, posYIn, posZIn );
        this.particleScale = 2.0F;
        this.particleMaxAge = 5;

        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite( PARTICLE_LASER.toString() );
        setParticleTexture( sprite );
	}

    @Override
    public boolean isTransparent()
    {
        return true;
    }

    @Override
    public int getFXLayer()
    {
        return 1;
    }

	@Override
    public void onUpdate()
    {
        this.particleAlpha = 1.0f - (float)this.particleAge / (float)this.particleMaxAge;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setExpired();
        }
    }

	@Override
    public int getBrightnessForRender(float p_189214_1_)
    {
	    final int FULL_BRIGHTNESS_VALUE = 0xf000f0;
	    return FULL_BRIGHTNESS_VALUE;
    }
}
