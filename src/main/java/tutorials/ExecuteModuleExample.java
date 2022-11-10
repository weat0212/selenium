package main.java.tutorials;

import main.java.creations.Module;
import main.java.creations.WindowsWebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteModuleExample {

    public static void main(String[] args) throws IOException {
        WebDriver webDriver = WindowsWebDriverFactory.getInstance().createChromeDriver();

        // 開啟URL
        String url = "https://www.google.com";
        webDriver.get(url);

        // 將不同畫面分為不同模組來執行
        List<Module> modules = new ArrayList<>();
        modules.add(new ModuleExample(webDriver));

        for (Module module : modules) {
            module.action();
        }
    }
}
