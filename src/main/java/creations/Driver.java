package main.java.creations;

import java.util.stream.Stream;

public enum Driver {
    Chrome("ChromeDriver"),
    Firefox("FirefoxDriver"),
    IE("InternetExplorer"),
    Safari("SafariDriver");

    private String driverName;

    public String getDriverName() {
        return this.driverName;
    }

    Driver(String driverName) {
        this.driverName = driverName;
    }

    public static Driver findByDriverName(String driverName) {
        if (driverName.isEmpty()) {
            return null;
        }
        return Stream.of(Driver.values())
                .filter(d -> d.getDriverName().equals(driverName))
                .findFirst().orElse(null);
    }
}
