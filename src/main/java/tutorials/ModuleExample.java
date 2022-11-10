package main.java.tutorials;

import main.java.creations.Module;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ModuleExample implements Module {

    private WebDriver webDriver;

    public ModuleExample(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        // 對畫面進行操作
        WebElement inputField = webDriver.findElement(By.tagName("input"));
        inputField.sendKeys("Hello Selenium");
    }
}
