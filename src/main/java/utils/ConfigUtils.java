package main.java.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 取得Properties資料
 */
public class ConfigUtils {

    private static PropertiesConfiguration config;

    static {
        config = new PropertiesConfiguration();
        try {
            config.load("application.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperties(String propertyName) {
        return config.getString(propertyName);
    }

    public static int getNumericProperties(String propertyName) {
        return config.getInt(propertyName);
    }
}
