package com.functions.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static DriverFactory driverFactory = null;

    public DriverFactory() {
    }

    public static DriverFactory getInstance() {

        if (driverFactory == null) {
            driverFactory = new DriverFactory();
        }
        return driverFactory;
    }

    public WebDriver init_driver(String browser) {

//        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {

//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("start-maximized"); // open Browser in maximized mode
//			options.addArguments("disable-infobars"); // disabling infobars
//			options.addArguments("--disable-extensions"); // disabling extensions
//			options.addArguments("--disable-gpu"); // applicable to windows os only
//			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//			options.addArguments("--no-sandbox"); // Bypass OS security model
            //WebDriver tlDriver = new ChromeDriver(options);
//			WebDriverManager.chromedriver().setup();
//			tlDriver.set(new ChromeDriver(options));

            //	System.setProperty("webdriver.chrome.driver", ConfigReader.getConfigValue("chromepath"));
//			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\com\\functions\\factory\\chromedriver.exe");
//			tlDriver.set(new ChromeDriver(options));


//			WebDriverManager.chromedriver().setup();
            //cloud
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--headless");
//			tlDriver.set(new ChromeDriver(options));

            ChromeOptions options = new ChromeOptions();
//			options.addExtensions(new File(".\\src\\main\\java\\com\\functions\\factory\\extension_5_3_2_0.crx"));
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			options.merge(capabilities);
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox");

          //  ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
		//	tlDriver.set(new ChromeDriver(options));
            driver.set(new ChromeDriver(options));



        }
        if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
           // options.addArguments("--headless");
            driver.set(new FirefoxDriver(options));
        }

        else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }


}
