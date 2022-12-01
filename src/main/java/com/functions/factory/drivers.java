package com.functions.factory;

import com.functions.util.ConfigReader;
import org.openqa.selenium.WebDriver;

public class drivers {

    private DriverFactory driverFactory = DriverFactory.getInstance();
    private ConfigReader configReader = ConfigReader.getInstance();
    public WebDriver driver;

    private static drivers drivers = null;

    public drivers() {
    }

    public static drivers getInstance() {

        if (drivers == null) {
            drivers = new drivers();
        }
        return drivers;
    }


    public WebDriver driverLaunch() {
        System.out.println("browser : " + configReader.getValue("browser"));
        driver = driverFactory.init_driver(configReader.getValue("browser"));
        driver = driverFactory.getDriver();
        configReader.setDriver("driver", driver);
        return driver;

    }
}
