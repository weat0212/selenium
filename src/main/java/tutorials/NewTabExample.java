package main.java.tutorials;

import main.java.creations.WindowsWebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class NewTabExample {

    public static void main(String[] args) {

        WebDriver driver = WindowsWebDriverFactory.getInstance().createEdgeDriver();
        driver.switchTo().newWindow(WindowType.TAB);
    }
}
