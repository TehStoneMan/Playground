package io.github.tehstoneman.playground.event;

// @Mod.EventBusSubscriber
public class WorldEvents
{
	/*
	 * @SubscribeEvent
	 * public static void onCreateSpawnPosition( WorldEvent.CreateSpawnPosition event )
	 * {
	 * final ServerLevelAccessor world = (ServerLevelAccessor)event.getWorld();
	 * final ServerLevelData worldInfo = event.getSettings();
	 * if( world == null )
	 * return;
	 * BlockPos spawnPos = null;
	 *
	 * // final ChunkGenerator chunkgenerator = world.getChunkSource().getGenerator();
	 * // final BiomeSource biomeprovider = chunkgenerator.getBiomeSource();
	 *
	 * if( PlaygroundConfig.COMMON.spawnAtStructure.get() )
	 * {
	 * final StructureFeature< ? > structure = ForgeRegistries.STRUCTURE_FEATURES
	 * .getValue( new ResourceLocation( PlaygroundConfig.COMMON.structure.get() ) );
	 * if( structure == null )
	 * Playground.LOGGER.error( String.format( "Invalid structure name %s", PlaygroundConfig.COMMON.structure.get() ) );
	 * else
	 * {
	 * spawnPos = world.getLevel().findNearestMapFeature( structure, new BlockPos( 0, 100, 0 ),
	 * PlaygroundConfig.COMMON.structureSearchRange.get(), false );
	 * if( spawnPos == null )
	 * Playground.LOGGER.error( String.format( "Structure %s not found in range %dm", PlaygroundConfig.COMMON.structure.get(),
	 * PlaygroundConfig.COMMON.structureSearchRange.get() ) );
	 * }
	 * }
	 *
	 * Playground.LOGGER.info( "Biome : " + PlaygroundConfig.COMMON.spawnInBiome.get() + " : " + PlaygroundConfig.COMMON.biome.get() );
	 * if( PlaygroundConfig.COMMON.spawnInBiome.get() && spawnPos == null )
	 * {
	 * final Biome biome = ForgeRegistries.BIOMES.getValue( new ResourceLocation( PlaygroundConfig.COMMON.biome.get() ) );
	 * if( biome == null )
	 * Playground.LOGGER.error( String.format( "Invalid biome name %s", PlaygroundConfig.COMMON.biome.get() ) );
	 * else
	 * {
	 * // final Random random = new Random( world.getSeed() );
	 * spawnPos = world.getLevel().findNearestBiome( biome, spawnPos, PlaygroundConfig.COMMON.biomeSearchRange.get(), 0 );
	 * spawnPos = biomeprovider.findBiomeHorizontal( 0, world.getSeaLevel(), 0, PlaygroundConfig.COMMON.biomeSearchRange.get(), 1,
	 * ( test ) ->
	 * {
	 * return test.getRegistryName().equals( biome.getRegistryName() );
	 * }, random, true );
	 *
	 * if( spawnPos == null )
	 * Playground.LOGGER.error( String.format( "Biome %s not found in range %dm", PlaygroundConfig.COMMON.biome.get(),
	 * PlaygroundConfig.COMMON.biomeSearchRange.get() ) );
	 * }
	 * }
	 *
	 * if( spawnPos != null )
	 * {
	 * final ChunkPos chunkPos = new ChunkPos( spawnPos );
	 *
	 * Playground.LOGGER.info( spawnPos + " : " + chunkPos );
	 *
	 * boolean flag = false;
	 *
	 * for( final Block block : BlockTags.VALID_SPAWN.getValues() )
	 * if( biomeprovider.getSurfaceBlocks().contains( block.defaultBlockState() ) )
	 * {
	 * flag = true;
	 * break;
	 * }
	 *
	 * worldInfo.setSpawn( chunkPos.getWorldPosition().offset( 8, chunkgenerator.getSpawnHeight(), 8 ), 0.0F );
	 *
	 * event.setCanceled( true );
	 * }
	 * }
	 */
}
