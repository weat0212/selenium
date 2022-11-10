package main.java.firstlife;

import main.java.creations.WindowsWebDriverFactory;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;

/**
 * @author created by andy.wang
 * @Date on 2022/6/15
 */
public class OtpFail3Times {

    public static WebDriver webDriver;

    public static void main(String[] args) throws IOException {

        webDriver = WindowsWebDriverFactory.getInstance().createDriver("Chrome");

        webDriver.get("http://localhost:4200/fleservice/register/p001");

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.terms")));

        scrollTermsAndClick();

        fillUpForm();

        confirm();

        sendOtp();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));

        for (int i=0; i<3; i++) {
            resetPassword();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-dialog-2\"]/app-dialog/div/div[2]/a[2]"))).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-dialog-3\"]/app-dialog/div/div[2]/a"))).click();
        }
    }

    private static void resetPassword() throws IOException {

        webDriver.findElements(By.tagName("input")).get(0).sendKeys(ConfigUtils.getProperties("firstlife.testdata.user1.id"));

        webDriver.findElements(By.tagName("input")).get(1).sendKeys(inputValue("OTP"));

        String newPassword = "andy1234";

        // 新密碼
        webDriver.findElements(By.tagName("input")).get(2).sendKeys(newPassword);
        webDriver.findElements(By.tagName("input")).get(3).sendKeys(newPassword);

        webDriver.findElements(By.tagName("input")).get(4).sendKeys(inputValue("kaptcha"));

        // 確認送出
        webDriver.findElement(By.className("check_ac")).click();

        // 確認送出彈窗
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-4\"]/app-dialog/div/div[2]/a[2]"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-5\"]/app-dialog/div/div[2]/a"))).click();
    }

    private static void sendOtp() {

        var contactButton = By.className("radio");

        // 點選第一個聯絡資料
        getWait().until(ExpectedConditions.visibilityOfElementLocated(contactButton)).click();

        // 送出
        webDriver.findElement(By.className("btn2")).click();
        webDriver.findElements(By.className("btn2")).get(1).click();
    }

    private static void confirm() {

        webDriver.findElement(By.className("check_ac")).click();
    }

    private static void fillUpForm() throws IOException {

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[1]/div/div[1]/label/input"))
                .sendKeys("N231874516");

        webDriver.findElement(By.name("date_start_1")).sendKeys(ConfigUtils.getProperties("firstlife.testdata.user1.birthday"));

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[2]/div/div/label/input"))
                .sendKeys(inputValue("Kaptcha"));
    }

    private static void scrollTermsAndClick() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        // Scroll
        js.executeScript("document.getElementsByClassName('terms')[0].scroll(0, 100)");
        js.executeScript("document.getElementsByClassName('terms')[1].scroll(0, 100)");
        js.executeScript("document.getElementsByClassName('terms')[2].scroll(0, 300)");

        // Click
        List<WebElement> clicks = webDriver.findElements(By.cssSelector(".checkMark"));
        clicks.forEach(WebElement::click);
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofMinutes(1));
    }

    private static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
