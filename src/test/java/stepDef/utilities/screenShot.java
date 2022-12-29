package stepDef.utilities;

import com.functions.util.ConfigReader;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

public class screenShot {

    public ConfigReader configReader = ConfigReader.getInstance();

    public static WebDriver driver;

    public static Scenario scenario;

    private static screenShot screenShot = null;

    public screenShot() {
    }

    public static screenShot getInstance() {

        if (screenShot == null) {
            screenShot = new screenShot();
        }
        return screenShot;
    }


    public  void takescreenshot(String screenShotName) {


        try {
           // System.out.println(configReader.getScenarioContext("Scenario"));
            driver = configReader.getDriver("driver");
            System.out.println(" ss driver : " + driver);
            scenario = (Scenario) configReader.getScenarioContext("Scenario");

            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenShotName);

        } catch (Exception e) {
            System.out.println("screen shot not found");
        }
    }


    public  void takeElementScreenShot(String screenShotName,WebElement element){

       try {
           byte[] file = element.getScreenshotAs(OutputType.BYTES);
           scenario.attach(file, "image/png", screenShotName);
       }
       catch (Exception e){
           System.out.println("element screenShot not found");
       }

    }

    public  void fieldname(String name) {

        try {

            scenario = (Scenario) configReader.getScenarioContext("Scenario");
            scenario.log(name);
        }
        catch (Exception e){
            System.out.println("field name not found");
        }
    }
}
