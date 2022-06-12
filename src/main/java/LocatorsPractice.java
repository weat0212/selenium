package main.java;

import org.openqa.selenium.WebDriver;

public class LocatorsPractice {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = WebDriverFactory.getInstance().getDriver(Driver.Chrome.toString());
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

    }
}
