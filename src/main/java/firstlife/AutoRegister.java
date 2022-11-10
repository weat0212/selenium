package main.java.firstlife;

import main.java.utils.IOUtils;
import main.java.creations.WindowsWebDriverFactory;
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
 * @Date on 2022/6/14
 */
public class AutoRegister {

    public static WebDriver webDriver;

    public static String id = "N231874516";

    public static void main(String[] args) throws IOException {

        webDriver = WindowsWebDriverFactory.getInstance().createDriver("Chrome");

        webDriver.get("http://localhost:4200/fleservice/register/p001");

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.terms")));

        scrollTermsAndClick();

        fillUpForm();

        confirm();

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));

        System.out.println("進入OTP流程...");

        sendOtp();

        System.out.println("進入首次重置密碼流程...");
        resetPassword();
    }

    private static void confirm() {

        webDriver.findElement(By.className("check_ac")).click();
    }

    private static void fillUpForm() throws IOException {

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[1]/div/div[1]/label/input"))
                .sendKeys(id);

        webDriver.findElement(By.name("date_start_1")).sendKeys("1977-06-06");

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
        return new WebDriverWait(webDriver, Duration.ofMinutes(2));
    }

    private static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private static void sendOtp() {

        var contactButton = By.className("radio");

        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactButton));

        // 點選第一個聯絡資料
        webDriver.findElements(contactButton).get(0).click();

        // 送出
        webDriver.findElement(By.className("btn2")).click();
        webDriver.findElements(By.className("btn2")).get(1).click();

    }

    private static void resetPassword() throws IOException {

        getWait().until(ExpectedConditions.elementToBeClickable(By.tagName("input")));

        List<WebElement> webElements = webDriver.findElements(By.tagName("input"));

        webElements.get(0).sendKeys(id);

        webElements.get(1).sendKeys(IOUtils.inputValue("OTP"));

        String newPassword = inputValue("New Password");

        // 新密碼
        webElements.get(2).sendKeys(newPassword);
        webElements.get(3).sendKeys(newPassword);

        String kaptcha = inputValue("kaptcha");

        webElements.get(4).sendKeys(kaptcha);

        // 確認送出
        webDriver.findElement(By.className("check_ac")).click();

        // 確認送出彈窗
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-dialog-0\"]/app-dialog/div/div[2]/a[2]"))).click();
    }
}
