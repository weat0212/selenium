package main.java.firstlife.modules;

import main.java.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * @author created by andy.wang
 * @Date on 2022/6/16
 */
public class RegisterModule {

    private WebDriver webDriver;

    RegisterModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void scrollTermsAndClick() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        // Scroll
        js.executeScript("document.getElementsByClassName('terms')[0].scroll(0, 100)");
        js.executeScript("document.getElementsByClassName('terms')[1].scroll(0, 100)");
        js.executeScript("document.getElementsByClassName('terms')[2].scroll(0, 300)");

        // Click
        List<WebElement> clicks = webDriver.findElements(By.cssSelector(".checkMark"));
        clicks.forEach(WebElement::click);
    }

    public void fillUpRegisterForm() throws IOException {

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[1]/div/div[1]/label/input"))
                .sendKeys("N231874516");

        webDriver.findElement(By.name("date_start_1")).sendKeys("1977-06-06");

        webDriver.findElement(By.xpath("/html/body/app-root/app-fes500w/app-p001/div/div[2]/div/form[2]/div[2]/div/div/label/input"))
                .sendKeys(CommonUtils.inputValue("Kaptcha"));
    }
}
