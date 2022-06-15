package main.java.project;

import main.java.WebDriverFactory;
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

    public static void main(String[] args) throws IOException {

        webDriver = WebDriverFactory.getInstance().getDriver("Chrome");

        webDriver.get("http://localhost:4200/fleservice/register/p001");

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.terms")));

        scrollTermsAndClick();

        fillUpForm();

        confirm();
    }

    private static void confirm() {

        webDriver.findElement(By.className("check_ac")).click();
    }

    private static void fillUpForm() throws IOException {

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[1]/div/div[1]/label/input"))
                .sendKeys(inputValue("Security No"));

        webDriver.findElement(By.name("date_start_1")).sendKeys(inputValue("Birth"));



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
        return new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private static String inputValue(String msg) throws IOException {
        System.out.println("Enter ".concat(msg));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
