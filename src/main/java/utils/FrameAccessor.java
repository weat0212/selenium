package main.java.utils;

import main.java.creations.DriverWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * 進入iframe & frame
 */
public class FrameAccessor {

    public static void focusOnFrame(WebDriver webDriver) {

        DriverWaitFactory.waitMin(webDriver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("frame")));

        //Store the web element
        WebElement frame = webDriver.findElement(By.tagName("frame"));

        //Switch to the frame
        webDriver.switchTo().frame(frame);
    }

    public static void focusOnIframe(WebDriver webDriver) {

        DriverWaitFactory.waitMin(webDriver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));

        WebElement iframe = webDriver.findElement(By.tagName("iframe"));

        webDriver.switchTo().frame(iframe);
    }
}
