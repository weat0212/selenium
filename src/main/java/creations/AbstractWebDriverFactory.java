package main.java.creations;

import org.openqa.selenium.WebDriver;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public interface AbstractWebDriverFactory {

    WebDriver createDriver(String driverName);

    void setProperty();
}
