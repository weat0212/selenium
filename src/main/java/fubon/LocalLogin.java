package main.java.fubon;

import main.java.creations.Module;
import main.java.creations.WindowsWebDriverFactory;
import main.java.fubon.modules.CafLoginModule;
import main.java.fubon.modules.CafOtpModule;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalLogin {

    public static void main(String[] args) throws IOException {

        WebDriver webDriver = WindowsWebDriverFactory.getInstance().createEdgeDriver();
        webDriver.manage().window().maximize();

        webDriver.get(ConfigUtils.getProperties("fubon.local.ext.caf.url"));

        List<Module> modules = new ArrayList<>();
        modules.add(new CafLoginModule(webDriver));
        modules.add(new CafOtpModule(webDriver));

        for (Module module : modules) {
            module.action();
        }
    }
}
