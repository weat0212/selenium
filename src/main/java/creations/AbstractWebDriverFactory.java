package main.java.creations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public abstract class AbstractWebDriverFactory {

    abstract void setChromeProperty();

    abstract void setEdgeProperty();

    abstract void setFirefoxProperty();

    abstract void setSafariProperty();

    abstract void setIEProperty();

    public WebDriver createDriver(String driverName) {

        DriverType driverType = DriverType.valueOf(driverName);

        switch (driverType) {
            case CHROME -> {
                return createChromeDriver();
            }
            case EDGE -> {
                return createEdgeDriver();
            }
            case FIREFOX -> {
                return createFirefoxDriver();
            }
            case SAFARI -> {
                return createSafariDriver();
            }
            case IE -> {
                return createIEDriver();
            }
            default -> throw new IllegalArgumentException("Error driver type: " + driverName);
        }
    }

    public WebDriver createChromeDriver() {
        setChromeProperty();
        return new ChromeDriver();
    }

    public WebDriver createEdgeDriver() {
        setEdgeProperty();
        return new EdgeDriver();
    }

    public WebDriver createFirefoxDriver() {
        setFirefoxProperty();
        return new FirefoxDriver();
    }

    public WebDriver createSafariDriver() {
        setSafariProperty();
        return new SafariDriver();
    }

    public WebDriver createIEDriver() {
        setIEProperty();
        return new InternetExplorerDriver();
    }
}
