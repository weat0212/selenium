package main.java.fubon.modules;

import main.java.creations.DriverWaitFactory;
import main.java.creations.Module;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CafOtpModule implements Module {

    private WebDriver webDriver;

    public CafOtpModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
//        waitUntilOtpPageLoaded();
        openNewTab();
        queryOtp();
        inputOtp(getOtp());
    }


    private void waitUntilOtpPageLoaded() {
        WebDriverWait waitMin = DriverWaitFactory.waitMin(webDriver, 2);
        waitMin.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.id("framebg"))));
    }

    private void openNewTab() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get(ConfigUtils.getProperties("fubon.uat.ext.otp.url"));
    }

    private void queryOtp() {
        DriverWaitFactory.waitSec(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("notifyType")));
        Select select = new Select(webDriver.findElement(By.id("notifyType")));
        select.selectByIndex(1);
        webDriver.findElement(By.cssSelector("input[type=button]")).click();
    }

    private String getOtp() {
        return null;
    }

    private void inputOtp(String otp) {
        System.out.println(otp);
    }
}
