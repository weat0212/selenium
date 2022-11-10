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
 * @Date on 2022/6/14
 */
public class ForgetPasswordAndReset {

    private static String otp;

    private static String id;

    private static String birth;

    private static WebDriver webDriver;

    public static void main(String[] args) throws IOException {

        webDriver = WindowsWebDriverFactory.getInstance().createDriver("Chrome");

        webDriver.get("http://localhost:4200/fleservice/register/p002");

        id = ConfigUtils.getProperties("firstlife.testdata.user1.id");
        birth = ConfigUtils.getProperties("firstlife.testdata.user1.birthday");

        forgetPassword();

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        sendOtp();

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        login();

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        resetPassword();
    }

    private static void forgetPassword() throws IOException {

        String captcha = inputValue("kaptcha");

        // 身分證
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p002/div/div[2]/div/div[1]/div/div[1]/label/input")).sendKeys(id);

        // 生日
        webDriver.findElement(By.id("date_start_1")).sendKeys(birth);

        // 輸入驗證碼
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p002/div/div[2]/div/div[1]/div/div[3]/label/input"))
                .sendKeys(captcha);

        // 送出
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p002/div/div[2]/div/div[2]/a[3]")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        webDriver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-dialog/div/div[2]/a[2]")).click();
    }

    private static void sendOtp() {

        var contactButton = By.xpath("/html/body/app-root/app-fes500w/app-forgot-password-otp/div/div[2]/div/div[2]/div[1]/label");

        getWait().until(ExpectedConditions.elementToBeClickable(contactButton));

        // 點選第一個聯絡資料
        webDriver.findElement(contactButton).click();

        // 送出
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-forgot-password-otp/div/div[2]/div/div[3]/a")).click();
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-forgot-password-otp/div/div[2]/div/div[2]/a[2]")).click();

        // 確認紐
        var confirm = By.xpath("//*[@id=\"mat-dialog-1\"]/app-dialog/div/div[2]/a");
        getWait().until(ExpectedConditions.elementToBeClickable(confirm)).click();

    }


    private static void login() throws IOException {

        webDriver.findElement(By.name("id")).sendKeys(id);

        ForgetPasswordAndReset.otp = inputValue("OTP");

        webDriver.findElement(By.name("password")).sendKeys(otp);

        String kaptcha = inputValue("kaptcha");

        webDriver.findElement(By.name("kaptcha")).sendKeys(kaptcha);

        webDriver.findElement(By.cssSelector("form > div.login_btn_box > a")).click();

        // 記住帳號
        getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"mat-dialog-2\"]/app-dialog/div/div[2]/a[2]"))).click();

        // 密碼變更
        getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"mat-dialog-3\"]/app-dialog/div/div[2]/a"))).click();
    }

    private static void resetPassword() throws IOException {

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[1]/div/div[1]/label/input"))
                .sendKeys(id);

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[1]/div/div[2]/label/input"))
                .sendKeys(otp);

        String newPassword = inputValue("New Password");

        // 新密碼
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[1]/div/div[3]/label/input"))
                .sendKeys(newPassword);
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[1]/div/div[4]/label/input"))
                .sendKeys(newPassword);

        String kaptcha = inputValue("kaptcha");

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[1]/div/div[5]/label/input"))
                .sendKeys(kaptcha);

        // 確認送出
        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-reset-password/div/div[3]/div/div[2]/a[2]")).click();

        // 確認送出彈窗
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-4\"]/app-dialog/div/div[2]/a[2]"))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-5\"]/app-dialog/div/div[2]/a"))).click();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofMinutes(2));
    }

    private static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
