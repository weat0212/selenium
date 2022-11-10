package main.java.tutorials;

import main.java.creations.WindowsWebDriverFactory;
import org.openqa.selenium.WebDriver;

public class OpenExploreExample {

    /**
     * 此範例為開啟網頁
     * @param args
     */
    public static void main(String[] args) {

        WebDriver driver = WindowsWebDriverFactory.getInstance().createChromeDriver();

        // 開啟URL
        String url = "https://www.google.com";
        driver.get(url);

        // 最大化視窗
        driver.manage().window().maximize();
    }
}
