package main.java.creations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class MacWebDriverFactory implements AbstractWebDriverFactory {

    private MacWebDriverFactory() {
        setProperty();
    }

    private static MacWebDriverFactory instance;

    public static MacWebDriverFactory getInstance() {
        if (instance == null) {
            instance = new MacWebDriverFactory();
        }
        return instance;
    }

    @Override
    public WebDriver createDriver(String driverName) {

        switch (driverName) {
            case "Chrome" -> { return new ChromeDriver(); }
            case "Firefox" -> { return new FirefoxDriver(); }
            case "Safari" -> { return new SafariDriver(); }
            case "IE" -> { return new InternetExplorerDriver(); }
            default -> { return null; }
        }
    }

    public WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
}
