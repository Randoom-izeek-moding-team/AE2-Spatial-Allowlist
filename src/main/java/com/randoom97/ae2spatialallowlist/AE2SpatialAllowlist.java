package com.randoom97.ae2spatialallowlist;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;
import net.minecraftforge.client.ClientCommandHandler;

@Mod(modid = AE2SpatialAllowlist.ModId, name = AE2SpatialAllowlist.ModName, version = AE2SpatialAllowlist.Version, acceptedMinecraftVersions = "[1.7.10]", dependencies = AE2SpatialAllowlist.Dependencies)
public class AE2SpatialAllowlist {
	
	public static final String ModId = "ae2spatialallowlist";
	public static final String ModName = "AE2 Spatial Allowlist";
	public static final String Version = "1.0.0";
	public static final String Dependencies = "required-after:appliedenergistics2";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	Config.syncronizeConfiguration(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new ClassPathCommand());
        for(String allowedTile : Config.allowedTiles) {
        	FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", allowedTile);
        }
    }
}