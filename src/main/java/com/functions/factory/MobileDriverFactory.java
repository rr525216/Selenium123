package com.functions.factory;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverFactory{

    WebDriver driver;

    public WebDriver mobileDriverLaunch() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "RMX2117");
        desiredCapabilities.setCapability("appium:platformVersion", "12");
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appium:udid", "89T4PF9LM7IRBMP7");
        desiredCapabilities.setCapability("appium:appActivity", "calculator.innovit.com.calculatrice.MainActivity");
        desiredCapabilities.setCapability("appium:appPackage", "calculator.innovit.com.calculatrice");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

}
