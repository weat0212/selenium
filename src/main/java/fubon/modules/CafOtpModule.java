package main.java.fubon.modules;

import main.java.creations.DriverWaitFactory;
import main.java.creations.Module;
import main.java.utils.ConfigUtils;
import main.java.utils.FrameAccessor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CafOtpModule implements Module {

    public static final String TX_ID = "CAFTX001";
    public static final int COLUMN_INDEX = 3;
    public static final int LINK_INDEX = 0;
    private WebDriver webDriver;

    public CafOtpModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        try {
            waitUntilOtpPageLoaded();
        } catch (Exception ex) {
            if (isAlertPresent()) {
                webDriver.switchTo().alert().accept();
            }
            new CafLoginModule(webDriver).action();
        }
        openNewTab();
        queryOtp();
        openLink();
        inputOtp(getOtp());
    }

    private void waitUntilOtpPageLoaded() {
        FrameAccessor.focusOnFrame(webDriver);
        FrameAccessor.focusOnIframe(webDriver);
//        System.out.println("wait for mask...");
//        WebDriverWait waitMin = DriverWaitFactory.waitMin(webDriver, 2);
//        waitMin.until(ExpectedConditions.presenceOfElementLocated(By.id("framebg")));
//        System.out.println("mask show");
//        waitMin.until(ExpectedConditions.invisibilityOfElementLocated(By.id("framebg")));
//        System.out.println("mask miss");
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

    private void openLink() {
        WebElement table = webDriver.findElement(By.id("result"));
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        System.out.printf("Total Rows: %s %n", tableRows.size());
        for (int i = 1; i < tableRows.size(); i++) {
            List<WebElement> col = tableRows.get(i).findElements(By.tagName("td"));
            if (col.get(COLUMN_INDEX).getText().equals(TX_ID)) {
                col.get(LINK_INDEX).click();
                break;
            }
        }
    }

    private String getOtp() {
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(2));
        String text = webDriver.findElement(By.tagName("body")).getText();
        String[] list = text.split(":");
        return list[3].substring(0, 6);
    }

    private void inputOtp(String otp) {
        System.out.println("OTP: " + otp);
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(0));

        FrameAccessor.focusOnFrame(webDriver);
        FrameAccessor.focusOnIframe(webDriver);

        WebElement otpField = webDriver.findElement(By.cssSelector("input[type='tel']"));
        otpField.sendKeys(otp);
        WebElement next = webDriver.findElement(By.cssSelector("div.btn-area > a"));
        next.click();
    }

    public boolean isAlertPresent() {
        try {
            webDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
