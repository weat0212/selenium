package main.java.tutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author created by andy.wang
 * @Date on 2022/5/20
 */
public class SeleniumIntro {

    /**
     * 觸發瀏覽器
     */
    public static void main(String[] args) {

        // 設置chromedriver.exe路徑
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Chrome -> ChromeDriver
        // FireFox -> FirefoxDriver
        // Safari -> SafariDriver
        WebDriver chromeDriver = new ChromeDriver();

        // 開啟網址
        chromeDriver.get("https://www.books.com.tw/");

        // 取得網頁主標題
        System.out.println(chromeDriver.getTitle());

        // 取得當前路徑
        System.out.println(chromeDriver.getCurrentUrl());

        // 取得最後載入頁面的原始碼
        System.out.println(chromeDriver.getPageSource());

        // 關閉當前分頁
        chromeDriver.close();

        // 關閉整個瀏覽器
//        chromeDriver.quit();
    }
}
