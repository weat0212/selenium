package main.java.creations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWaitBuilder {

    public static WebDriverWait waitFor30Sec(WebDriver webDriver) {

        if (webDriver == null) {
            return null;
        }

        return new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    public static WebDriverWait waitFor1Min(WebDriver webDriver) {

        if (webDriver == null) {
            return null;
        }

        return new WebDriverWait(webDriver, Duration.ofMinutes(1));
    }

    public static WebDriverWait waitFor5Min(WebDriver webDriver) {

        if (webDriver == null) {
            return null;
        }

        return new WebDriverWait(webDriver, Duration.ofMinutes(5));
    }
}
