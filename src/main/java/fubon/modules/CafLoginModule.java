package main.java.fubon.modules;

import main.java.creations.DriverWaitFactory;
import main.java.utils.FrameAccessor;
import main.java.creations.Module;
import main.java.utils.IOUtils;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

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
        FrameAccessor.focusOnFrame(webDriver);
        FrameAccessor.focusOnIframe(webDriver);
    }

    private void login() throws IOException {
        DriverWaitFactory.waitSec(webDriver, 15).until(
                ExpectedConditions.visibilityOfElementLocated(By.id("maskedIdNo")))
                .sendKeys(ConfigUtils.getProperties("fubon.testdata.user1.id"));
        String birth = ConfigUtils.getProperties("fubon.testdata.user1.birthday");
        webDriver.findElement(By.id("mbirthdayY")).sendKeys(birth.substring(0, 4));
        webDriver.findElement(By.id("mbirthdayM")).sendKeys(birth.substring(4, 6));
        webDriver.findElement(By.id("mbirthdayD")).sendKeys(birth.substring(6, 8));
        webDriver.findElement(By.id("captcha")).sendKeys(IOUtils.inputValue("Captcha"));
        webDriver.findElement(By.className("btn-main")).click();
    }
}
