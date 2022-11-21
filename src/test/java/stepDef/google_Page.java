package stepDef;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class google_Page {

    private static String title;

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        DriverFactory.getDriver()
                .get("http://www.amazon.in");

          addTestStepLog("testpass");

          loginPage.best();



    }
}
