package main.java.modules;

import main.java.creation.WebDriverWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RiskProfileModule implements Module {

    private WebDriver webDriver;

    public RiskProfileModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() {
        enter();
    }

    public void enter() {

        WebDriverWaitFactory.waitFor1Min(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.className("common")));

        webDriver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-fes200w/div/div[2]/div/div/div[2]/div[2]/a[1]")).click();

        WebDriverWaitFactory.waitFor30Sec(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.className("setting_card")));

        List<WebElement> cards = webDriver.findElements(By.className("setting_card"));
        cards.get(10).click();

        WebDriverWaitFactory.waitFor30Sec(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.small"))).click();
    }
}
