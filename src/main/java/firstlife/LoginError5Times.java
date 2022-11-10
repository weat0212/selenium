package main.java.firstlife;

import main.java.creations.WindowsWebDriverFactory;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class LoginError5Times {

    private static WebDriver webDriver;

    public static void main(String[] args) throws IOException {

        webDriver = WindowsWebDriverFactory.getInstance().createDriver("Chrome");

        webDriver.get("http://localhost:4200/fleservice/login");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));

        for (int i=0; i <=4; i++) {
            login("andy123".concat(String.valueOf(i)));
        }

        // 正確的
        login(inputValue("Correct Password"));
    }

    private static void login(String password) throws IOException {
        webDriver.findElement(By.name("id")).sendKeys(ConfigUtils.getProperties("firstlife.testdata.user1.id"));

        webDriver.findElement(By.name("password")).sendKeys(password);

        webDriver.findElement(By.name("kaptcha")).sendKeys(inputValue("Kaptcha"));

        webDriver.findElement(By.className("login")).click();

        var dialog = By.xpath("//*[@id=\"mat-dialog-0\"]/app-dialog/div/div[2]/a[1]");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(dialog));

        webDriver.findElement(dialog).click();

        var errorDialog = By.xpath("//*[@id=\"mat-dialog-1\"]/app-dialog/div/div[2]/a");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(errorDialog));
        webDriver.findElement(errorDialog).click();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
