package stepDef;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
//import com.qa.util.testContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class google_Page {

    private static String title;

    public static WebDriver driver;

    public static Scenario scenario;

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

  //  testContext testcontext = new testContext();
    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        DriverFactory.getDriver()
                .get("http://www.amazon.in");
        ConfigReader.setDriver("driver",DriverFactory.getDriver());
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
