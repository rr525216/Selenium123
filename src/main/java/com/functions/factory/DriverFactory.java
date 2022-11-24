package com.functions.factory;



import com.functions.util.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverFactory {

	public static WebDriver driver;



	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

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


			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			tlDriver.set(new ChromeDriver(options));

		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
