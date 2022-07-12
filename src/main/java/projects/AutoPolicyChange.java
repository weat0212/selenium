package main.java.projects;

import main.java.creations.WindowsWebDriverFactory;
import main.java.modules.LoginModule;
import main.java.modules.Module;
import main.java.modules.RiskProfileModule;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoPolicyChange {

    public static void main(String[] args) throws IOException {

        WebDriver webDriver = WindowsWebDriverFactory.getInstance().createChromeDriver();

        webDriver.get("http://localhost:4200/fleservice/login");

        List<Module> modules = new ArrayList<>();

        modules.add(new LoginModule(webDriver));
        modules.add(new RiskProfileModule(webDriver));

        for (Module module : modules) {
            module.action();
        }
    }
}
