package stepDef.utilities;

import com.functions.util.ConfigReader;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
    public static WebDriver driver;
    public static void takescreenshot(String screenShotName) {
        System.out.println(ConfigReader.getScenarioContext("Scenario"));
        Scenario scenario = (Scenario) ConfigReader.getScenarioContext("Scenario");
        driver = ConfigReader.getDriver("driver");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenShotName);
    }
}