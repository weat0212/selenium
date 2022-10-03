package main.java.fubon.modules;

import main.java.commons.Module;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Caftx002Module implements Module {

    private WebDriver webDriver;

    public Caftx002Module(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {

    }
}
