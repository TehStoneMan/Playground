package io.github.tehstoneman.playground.event;

import java.util.Random;

import io.github.tehstoneman.playground.Playground;
import io.github.tehstoneman.playground.config.PlaygroundConfig;
import net.minecraft.block.Block;
import net.minecraft.entity.player.SpawnLocationHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class WorldEvents
{
	@SubscribeEvent
	public static void onCreateSpawnPosition( WorldEvent.CreateSpawnPosition event )
	{
		final ServerWorld world = (ServerWorld)event.getWorld();
		final IServerWorldInfo worldInfo = event.getSettings();
		if( world == null )
			return;
		BlockPos spawnPos = null;

		final ChunkGenerator chunkgenerator = world.getChunkSource().getGenerator();
		final BiomeProvider biomeprovider = chunkgenerator.getBiomeSource();

		if( PlaygroundConfig.COMMON.spawnAtStructure.get() )
		{
			final Structure< ? > structure = ForgeRegistries.STRUCTURE_FEATURES
					.getValue( new ResourceLocation( PlaygroundConfig.COMMON.structure.get() ) );
			if( structure == null )
				Playground.LOGGER.error( String.format( "Invalid structure name %s", PlaygroundConfig.COMMON.structure.get() ) );
			else
			{
				spawnPos = world.findNearestMapFeature( structure, new BlockPos( 0, world.getSeaLevel(), 0 ),
						PlaygroundConfig.COMMON.structureSearchRange.get(), false );
				if( spawnPos == null )
					Playground.LOGGER.error( String.format( "Structure %s not found in range %dm", PlaygroundConfig.COMMON.structure.get(),
							PlaygroundConfig.COMMON.structureSearchRange.get() ) );
			}
		}

		Playground.LOGGER.info( "Biome : " + PlaygroundConfig.COMMON.spawnInBiome.get() + " : " + PlaygroundConfig.COMMON.biome.get() );
		if( PlaygroundConfig.COMMON.spawnInBiome.get() && spawnPos == null )
		{
			final Biome biome = ForgeRegistries.BIOMES.getValue( new ResourceLocation( PlaygroundConfig.COMMON.biome.get() ) );
			if( biome == null )
				Playground.LOGGER.error( String.format( "Invalid biome name %s", PlaygroundConfig.COMMON.biome.get() ) );
			else
			{
				final Random random = new Random( world.getSeed() );
				spawnPos = biomeprovider.findBiomeHorizontal( 0, world.getSeaLevel(), 0, PlaygroundConfig.COMMON.biomeSearchRange.get(), 1,
						( test ) ->
						{
							return test.getRegistryName().equals( biome.getRegistryName() );
						}, random, true );

				if( spawnPos == null )
					Playground.LOGGER.error( String.format( "Biome %s not found in range %dm", PlaygroundConfig.COMMON.biome.get(),
							PlaygroundConfig.COMMON.biomeSearchRange.get() ) );
			}
		}

		if( spawnPos != null )
		{
			final ChunkPos chunkPos = new ChunkPos( spawnPos );

			Playground.LOGGER.info( spawnPos + " : " + chunkPos );

			boolean flag = false;

			for( final Block block : BlockTags.VALID_SPAWN.getValues() )
				if( biomeprovider.getSurfaceBlocks().contains( block.defaultBlockState() ) )
				{
					flag = true;
					break;
				}

			worldInfo.setSpawn( chunkPos.getWorldPosition().offset( 8, chunkgenerator.getSpawnHeight(), 8 ), 0.0F );

			event.setCanceled( true );
		}
	}
}
