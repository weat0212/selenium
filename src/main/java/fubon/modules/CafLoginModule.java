package main.java.fubon.modules;

import main.java.commons.Module;
import main.java.utils.CommonUtils;
import main.java.utils.ConfigUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CafLoginModule implements Module {

    private WebDriver webDriver;

    public CafLoginModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        focusIframe();
        login();
    }

    private void focusIframe() {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("frame")));

        //Store the web element
        WebElement frame = webDriver.findElement(By.tagName("frame"));

        //Switch to the frame
        webDriver.switchTo().frame(frame);

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));

        WebElement iframe = webDriver.findElement(By.tagName("iframe"));

        webDriver.switchTo().frame(iframe);
    }

    private void login() throws IOException {
        getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.id("maskedIdNo")))
                .sendKeys(ConfigUtils.getProperties("fubon.testdata.user1.id"));
        String birth = ConfigUtils.getProperties("fubon.testdata.user1.birthday");
        webDriver.findElement(By.id("mbirthdayY")).sendKeys(birth.substring(0, 4));
        webDriver.findElement(By.id("mbirthdayM")).sendKeys(birth.substring(4, 6));
        webDriver.findElement(By.id("mbirthdayD")).sendKeys(birth.substring(6, 8));
        webDriver.findElement(By.id("captcha")).sendKeys(CommonUtils.inputValue("Captcha"));
        webDriver.findElement(By.className("btn-main")).click();
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }
}
