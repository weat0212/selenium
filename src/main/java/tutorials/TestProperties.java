package main.java.tutorials;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class TestProperties {

    public static void main(String[] args) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        config.load("application.properties");
        System.out.println(config.getString("testdata.user1.id"));
    }
}
