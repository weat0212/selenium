package main.java.creations;

import main.java.utils.ConfigUtils;

public class WindowsWebDriverFactory extends AbstractWebDriverFactory {

    private WindowsWebDriverFactory() {
    }

    private static WindowsWebDriverFactory instance;

    public static WindowsWebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WindowsWebDriverFactory();
        }
        return instance;
    }

    public void setChromeProperty() {
        System.setProperty("webdriver.chrome.driver", ConfigUtils.getProperties("windows.driver.chrome.location"));
    }

    public void setEdgeProperty() {
        System.setProperty("webdriver.edge.driver", ConfigUtils.getProperties("windows.driver.edge.location"));
    }

    @Override
    void setFirefoxProperty() {
        throw new UnsupportedOperationException("Not Implement...");
    }

    @Override
    void setSafariProperty() {
        throw new UnsupportedOperationException("Not Implement...");
    }

    @Override
    void setIEProperty() {
        throw new UnsupportedOperationException("Not Implement...");
    }
}
