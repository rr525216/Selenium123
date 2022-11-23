package stepDef.utilities;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.functions.factory.DriverFactory;
import com.functions.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void beforeStart(Scenario scenario){
		configReader = new ConfigReader();
		String browserName =configReader.getValue("browser");
		System.out.println("browser : " +browserName);
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		System.out.println("Scenario Name : " +scenario.getName());
		ConfigReader.setScenarioContext("Scenario",scenario);
 	}
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}

		try{

			testCount.counter(scenario);

		}
		catch (Exception e){
			System.out.println("count is not working");
		}
	}

}
