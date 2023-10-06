package com.randoom97.ae2spatialallowlist;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class Config {
    
    private static class Defaults {
    	public static final String[] allowedTiles = new String[0];
    }

    private static class Categories {
        public static final String general = "general";
    }
    
    public static String[] allowedTiles = Defaults.allowedTiles;

    public static void syncronizeConfiguration(File configFile) {
    	//TODO maybe make this a JSON
        Configuration configuration = new Configuration(configFile);
        configuration.load();
        
        Property allowedTilesProperty = configuration.get(Categories.general, "allowedTiles", Defaults.allowedTiles);
        allowedTiles = allowedTilesProperty.getStringList();

        if(configuration.hasChanged()) {
            configuration.save();
        }
    }
}