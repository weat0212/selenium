package main.java.creations;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class MacWebDriverFactory extends AbstractWebDriverFactory {

    private MacWebDriverFactory() {
    }

    private static MacWebDriverFactory instance;

    public static MacWebDriverFactory getInstance() {
        if (instance == null) {
            instance = new MacWebDriverFactory();
        }
        return instance;
    }

    @Override
    void setChromeProperty() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @Override
    void setEdgeProperty() {
        throw new UnsupportedOperationException("Not Implement...");
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
