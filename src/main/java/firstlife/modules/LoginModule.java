package main.java.firstlife.modules;

import main.java.creations.Module;
import main.java.utils.ConfigUtils;
import main.java.utils.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginModule implements Module {

    private WebDriver webDriver;

    public LoginModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        login();
    }

    public void login() throws IOException {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));

        String account = webDriver.findElement(By.name("id")).getText();

        if (account.isEmpty() || account == null) {
            webDriver.findElement(By.name("id")).sendKeys(ConfigUtils.getProperties("firstlife.testdata.user1.id"));
        }

        String password = webDriver.findElement(By.name("password")).getText();

        if (password.isEmpty() || password == null) {
            webDriver.findElement(By.name("password")).sendKeys("andy1234");
        }


        webDriver.findElement(By.name("kaptcha")).sendKeys(IOUtils.inputValue("Kaptcha"));

        webDriver.findElement(By.className("login")).click();

        var dialog = By.tagName("app-dialog");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(dialog));
        webDriver.findElement(By.className("brown")).click();

        IOUtils.inputValue("直到下個Dialog出現");

        var repeatLogin = By.tagName("app-dialog");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(repeatLogin));
        webDriver.findElements(By.cssSelector("app-dialog a.btn2")).get(1).click();
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }
}
