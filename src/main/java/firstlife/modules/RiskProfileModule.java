package main.java.firstlife.modules;

import main.java.creations.Module;
import main.java.creations.WebDriverWaitBuilder;
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
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
    }

    public void enter() {

        WebDriverWaitBuilder.waitFor1Min(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.className("common")));

        webDriver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-fes200w/div/div[2]/div/div/div[2]/div[2]/a[1]")).click();

        WebDriverWaitBuilder.waitFor30Sec(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.className("setting_card")));

        List<WebElement> cards = webDriver.findElements(By.className("setting_card"));
        cards.get(10).click();

        WebDriverWaitBuilder.waitFor30Sec(webDriver).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.small"))).click();
    }

    public void stepOne() {
        System.out.println("第一步驟開始...");
        webDriver.findElements(By.className("btn2")).get(1).click();
        System.out.println("第一步驟結束...");
    }

    private void stepTwo() {
        System.out.println("第二步驟開始...");
        // TODO: 點選各項答案
//        WebDriverWaitFactory.waitFor1Min(webDriver).until(ExpectedConditions.visibilityOfElementLocated())
        System.out.println("第二步驟結束...");
    }

    private void stepThree() {
        System.out.println("第三步驟開始...");
        System.out.println("第三步驟結束...");
    }

    private void stepFour() {
        System.out.println("第四步驟開始...");
        System.out.println("第四步驟結束...");
    }
}
