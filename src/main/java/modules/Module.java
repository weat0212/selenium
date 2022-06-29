package main.java.modules;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface Module {

    WebDriver webDriver = null;

    void action() throws IOException;
}
