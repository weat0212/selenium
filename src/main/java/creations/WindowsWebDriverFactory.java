package main.java.creations;

import main.java.commons.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

        DriverType driverType = DriverType.valueOf(driverName);

        switch (driverType) {
            case CHROME -> { return new ChromeDriver(); }
            case EDGE -> { return new EdgeDriver(); }
            case FIREFOX -> { return new FirefoxDriver(); }
            case SAFARI -> { return new SafariDriver(); }
            case IE -> { return new InternetExplorerDriver(); }
            default -> throw new IllegalArgumentException("Error driver type: " + driverName);
        }
    }

    @Override
    public void setProperty() {
//        setChromeProperty();
        setEdgeProperty();
    }

    public WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    public WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    public void setChromeProperty() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
    }

    public void setEdgeProperty() {
        System.setProperty("webdriver.edge.driver", "C:\\softwares\\edgedriver_win64\\msedgedriver.exe");
    }
}
