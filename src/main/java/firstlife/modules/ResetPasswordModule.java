package main.java.firstlife.modules;

import main.java.creations.Module;
import main.java.utils.IOUtils;
import main.java.creations.WebDriverWaitBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ResetPasswordModule implements Module {

    private WebDriver webDriver;

    public ResetPasswordModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        fillInForm();
    }

    private void fillInForm() throws IOException {
        System.out.println("開始填入資料...");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWaitBuilder.waitFor1Min(webDriver).until(ExpectedConditions.elementToBeClickable(By.tagName("input")));

        List<WebElement> inputs = webDriver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("N231874516");
        inputs.get(1).sendKeys("andy1234");
        inputs.get(2).sendKeys("andy4321");
        inputs.get(3).sendKeys("andy4321");
        inputs.get(4).sendKeys(IOUtils.inputValue("驗證碼"));

        webDriver.findElement(By.className("check_ac")).click();

        // Dialog
        WebDriverWaitBuilder.waitFor30Sec(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-dialog")));
        webDriver.findElements(By.cssSelector("app-dialog.btn2")).get(1).click();
    }
}
