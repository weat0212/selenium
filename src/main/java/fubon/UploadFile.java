package main.java.fubon;

import main.java.creations.WindowsWebDriverFactory;
import main.java.creations.Module;
import main.java.fubon.modules.CafLoginModule;
import main.java.fubon.modules.CafOtpModule;
import main.java.fubon.modules.Caftx002Module;
import main.java.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadFile {

    public static void main(String[] args) throws IOException {

        WebDriver webDriver = WindowsWebDriverFactory.getInstance().createEdgeDriver();

        webDriver.get(ConfigUtils.getProperties("fubon.uat.ext.caf.url"));

        List<Module> modules = new ArrayList<>();
        modules.add(new CafLoginModule(webDriver));
        modules.add(new CafOtpModule(webDriver));
        modules.add(new Caftx002Module(webDriver));

        for (Module module : modules) {
            module.action();
        }
    }

}
