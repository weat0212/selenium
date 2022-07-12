package main.java.tutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class MyWebDriver {

    private final WebDriver webDriver;

    MyWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriverWait waitMinutes(Integer mins) {
        return new WebDriverWait(this.webDriver, Duration.ofMinutes(mins));
    }
}
