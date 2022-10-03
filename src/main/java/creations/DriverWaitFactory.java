package main.java.creations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWaitFactory {

    public static WebDriverWait waitSec(WebDriver webDriver, int sec) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(sec));
    }

    public static WebDriverWait waitMin(WebDriver webDriver, int min) {
        return new WebDriverWait(webDriver, Duration.ofMinutes(min));
    }
}
