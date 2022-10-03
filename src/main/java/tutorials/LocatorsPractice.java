package main.java.tutorials;

import main.java.creations.Driver;
import main.java.creations.WindowsWebDriverFactory;
import org.openqa.selenium.WebDriver;

public class LocatorsPractice {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = WindowsWebDriverFactory.getInstance().createDriver(Driver.Chrome.toString());
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

    }
}
