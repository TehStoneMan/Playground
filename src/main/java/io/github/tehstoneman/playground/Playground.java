package io.github.tehstoneman.playground;

import io.github.tehstoneman.playground.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//@formatter:off
@Mod(	modid						= ModInfo.MODID,
		name						= ModInfo.NAME,
		version						= ModInfo.VERSION,
		//dependencies				= ModInfo.DEPENDENCIES,
		acceptedMinecraftVersions	= ModInfo.MINECRAFT )
//@formatter:on
public class Playground
{
	public static ModMetadata	modMetadata;

	@Instance( value = ModInfo.MODID )
	public static Playground	instance;

	// Define proxies
	@SidedProxy( clientSide = ModInfo.PROXY_LOCATION + "ClientProxy", serverSide = ModInfo.PROXY_LOCATION + "CommonProxy" )
	public static CommonProxy	proxy;

	@EventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		// MinecraftForge.EVENT_BUS.register( EventManager.class );
		proxy.preInit();
	}

	@EventHandler
	public void init( FMLInitializationEvent event )
	{
		proxy.Init();
	}

	@EventHandler
	public void postInit( FMLPostInitializationEvent event )
	{
		proxy.postInit();
	}

	/**
	 * Prepend the name with the mod ID, suitable for ResourceLocations such as
	 * textures.
	 * Adapted from MinecraftByExample
	 *
	 * @param name
	 * @return "modid:name"
	 */
	public static String modAsset( String name )
	{
		return ModInfo.MODID + ":" + name;
	}
}
