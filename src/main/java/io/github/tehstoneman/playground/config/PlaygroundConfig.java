package io.github.tehstoneman.playground.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class PlaygroundConfig
{
	private static final ForgeConfigSpec.Builder	COMMON_BUILDER	= new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder	CLIENT_BUILDER	= new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder	SERVER_BUILDER	= new ForgeConfigSpec.Builder();

	public static Common							COMMON			= new Common( COMMON_BUILDER );
	public static Client							CLIENT			= new Client( CLIENT_BUILDER );
	public static Server							SERVER			= new Server( SERVER_BUILDER );

	private static ForgeConfigSpec					COMMON_SPEC		= COMMON_BUILDER.build();
	private static ForgeConfigSpec					CLIENT_SPEC		= CLIENT_BUILDER.build();
	private static ForgeConfigSpec					SERVER_SPEC		= SERVER_BUILDER.build();

	public static class Common
	{
		public ForgeConfigSpec.BooleanValue				spawnAtStructure;
		public ForgeConfigSpec.ConfigValue< String >	structure;
		public ForgeConfigSpec.ConfigValue< Integer >	structureSearchRange;
		public ForgeConfigSpec.BooleanValue				spawnInBiome;
		public ForgeConfigSpec.ConfigValue< String >	biome;
		public ForgeConfigSpec.ConfigValue< Integer >	biomeSearchRange;

		public Common( Builder commonBuilder )
		{
			commonBuilder.comment( "Spawn point settings." ).push( "Spawn Point" );

			spawnAtStructure = commonBuilder.comment( "Set the world spawn point at the nearest structure." )
					.translation( "config.playground.spawn.spawnAtStructure" ).define( "spawnAtStructure", true );

			structure = commonBuilder.comment( "Structure to spawn near. Will fall through to biome if structure not found" )
					.translation( "config.playground.spawn.structure" ).define( "structure", "minecraft:village" );

			structureSearchRange = commonBuilder.comment( "Range to search for structure." )
					.translation( "config.playground.spawn.structureSearchRange" ).define( "structureSearchRange", 3200 );

			spawnInBiome = commonBuilder.comment( "Set the world spawn point in the nearest biome." )
					.translation( "config.playground.spawn.spawnInBiome" ).define( "spawnInBiome", true );

			biome = commonBuilder.comment( "Biome to spawn in. Will only apply if structure is false or not found" )
					.translation( "config.playground.spawn.biome" ).define( "biome", "minecraft:plains" );

			biomeSearchRange = commonBuilder.comment( "Range to search for biome." ).translation( "config.playground.spawn.biomeSearchRange" )
					.define( "biomeSearchRange", 6400 );

			commonBuilder.pop();
		}
	}

	public static class Client
	{
		public Client( Builder clientBuilder )
		{
			// TODO Auto-generated constructor stub
		}
	}

	public static class Server
	{
		public Server( Builder serverBuilder )
		{
			// TODO Auto-generated constructor stub
		}
	}

	public static void register( ModLoadingContext context )
	{
		context.registerConfig( ModConfig.Type.COMMON, COMMON_SPEC );
		context.registerConfig( ModConfig.Type.CLIENT, CLIENT_SPEC );
		context.registerConfig( ModConfig.Type.SERVER, SERVER_SPEC );
	}
}
