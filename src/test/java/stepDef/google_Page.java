package stepDef;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;

public class google_Page {

    private static String title;
  //  private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        DriverFactory.getDriver()
                .get("http://www.google.com");
    }
}
