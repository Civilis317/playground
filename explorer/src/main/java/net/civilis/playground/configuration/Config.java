package net.civilis.playground.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

public class Config {
    private static final String CONFIG_FILE_PATH = "explorer.properties.path";
    private static Logger logger = Logger.getLogger(Config.class.getName());

    private static PropertiesConfiguration config;

    static {
        try {
            String path = System.getProperty(CONFIG_FILE_PATH);
            config = new PropertiesConfiguration(path);
            config.setReloadingStrategy(new FileChangedReloadingStrategy());
        } catch (ConfigurationException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String getString(String key) {
        return config.getString(key);
    }

    public static int getInt(String key) {
        return config.getInt(key);
    }

    public static Integer getInteger(String key) {
        Integer defaultValue = null;
        return config.getInteger(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return config.getBoolean(key);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return config.getBoolean(key, defaultValue);
    }

}
