package main.java.firstlife;

import main.java.creations.WindowsWebDriverFactory;
import main.java.firstlife.modules.LoginModule;
import main.java.creations.Module;
import main.java.firstlife.modules.ResetPasswordModule;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OverdueResetPassword {

    public static void main(String[] args) throws IOException {

        WebDriver webDriver = WindowsWebDriverFactory.getInstance().createChromeDriver();

        webDriver.get("http://localhost:4200/fleservice/login");

        List<Module> modules = new ArrayList<>();

        modules.add(new LoginModule(webDriver));
        modules.add(new ResetPasswordModule(webDriver));

        for (Module module : modules) {
            module.action();
        }
    }
}
