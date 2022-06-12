package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriverFactory instance;

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String driverName) {

        setMacProperty();

        switch (driverName) {
            case "Chrome" -> { return new ChromeDriver(); }
            case "Firefox" -> { return new FirefoxDriver(); }
            case "Safari" -> { return new SafariDriver(); }
            case "IE" -> { return new InternetExplorerDriver(); }
            default -> { return null; }
        }
    }

    private void setMacProperty() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    private void setWindowsProperty() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
    }
}
