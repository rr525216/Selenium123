package com.functions.factory;


import com.functions.util.ConfigReader;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverFactory {

    WebDriver driver;

    ConfigReader configReader = ConfigReader.getInstance();

    public WebDriver mobileDriverLaunch() throws MalformedURLException {

        //mobile Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", configReader.getValue("platformName"));
        desiredCapabilities.setCapability("appium:deviceName", configReader.getValue("deviceName"));
        desiredCapabilities.setCapability("appium:platformVersion", configReader.getValue("platformVersion"));
        desiredCapabilities.setCapability("appium:automationName", configReader.getValue("automationName"));
        desiredCapabilities.setCapability("appium:udid", configReader.getValue("udid"));
        desiredCapabilities.setCapability("appium:appActivity", configReader.getValue("appActivity"));
        desiredCapabilities.setCapability("appium:appPackage", configReader.getValue("appPackage"));
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        //initialize the url
        URL remoteUrl = new URL(configReader.getValue("url"));

        //initialize the driver
        driver = new AppiumDriver(remoteUrl, desiredCapabilities);

        //adding the implicitlyWait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

}
