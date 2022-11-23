package stepDef.pages;

import com.pages.LoginPage;
import com.functions.factory.DriverFactory;
import com.functions.util.ConfigReader;
//import com.qa.util.testContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stepDef.utilities.screenShot;

import java.util.Properties;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class google_Page {

    private static String title;
    public static WebDriver driver;
    public static Scenario scenario;
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    Properties prop;
    private LoginPage loginPage ;

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        ConfigReader.setDriver("driver",DriverFactory.getDriver());
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.pageLogin(configReader.getValue("Url"));
        addTestStepLog("testpass");
        screenShot.takescreenshot("naveen1");

    }

    @And("User click Best")
    public void userClickBest() {

        loginPage.best();
        screenShot.takescreenshot("naveen2");
    }

    @Then("test fail")
    public void testFail() {

        Assert.fail();
    }
}
