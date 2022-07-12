package main.java.creations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WindowsWebDriverFactory implements AbstractWebDriverFactory {

    private WindowsWebDriverFactory() {
        setProperty();
    }

    private static WindowsWebDriverFactory instance;

    public static WindowsWebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WindowsWebDriverFactory();
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
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
    }
}
