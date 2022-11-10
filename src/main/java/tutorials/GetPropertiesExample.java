package main.java.tutorials;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class GetPropertiesExample {

    /**
     * 機密資料建立：src/main/resources/application.properties
     * @param args
     * @throws ConfigurationException
     */
    public static void main(String[] args) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration();
        config.load("application.properties");
        // 透過key取得其value
        System.out.println(config.getString("testdata.user1.id"));
    }
}
