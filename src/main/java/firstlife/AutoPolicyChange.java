package main.java.firstlife;

import main.java.creations.WindowsWebDriverFactory;
import main.java.firstlife.modules.LoginModule;
import main.java.commons.Module;
import main.java.firstlife.modules.RiskProfileModule;
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
