package com.qa.util;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class testContext {

    DriverFactory driverFactory;

    public static WebDriver driver;

    public testContext(){
        driverFactory = new DriverFactory();
    }

    public  DriverFactory getDriverFactory(){
        return driverFactory;
    }

    public static void   takeScreenShot(){

        driver =ConfigReader.getDriver("driver");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
     //   ConfigReader.getScenarioContext("Scenario").attach(sourcePath, "image/png", "screenShotName");
    }
}
