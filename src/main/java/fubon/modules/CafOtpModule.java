package main.java.fubon.modules;

import main.java.commons.Module;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CafOtpModule implements Module {

    private WebDriver webDriver;

    public CafOtpModule(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void action() throws IOException {
        getOtp();

    }

    private String getOtp() {
        return null;
    }

    private void doNext(String otp) {

    }
}
