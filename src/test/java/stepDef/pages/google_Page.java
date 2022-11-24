package stepDef.pages;

import com.pages.LoginPage;
import com.functions.factory.DriverFactory;
import com.functions.util.ConfigReader;
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
        screenShot.fieldname("abcpass");

    }

    @And("User click Best")
    public void userClickBest() {
        loginPage.best();
        screenShot.takescreenshot("best seller");
    }

    @Then("test fail")
    public void testFail() {

        Assert.fail();
    }

    @And("user click Best Seller {string}")
    public void userClickBestSeller(String arg0) {
        loginPage.bestselleproduct();
        screenShot.takescreenshot("bestseller product");


    }

    @And("user click Best Seller in {string}")
    public void userClickBestSellerIn(String arg0) {
        loginPage.music();
        screenShot.takescreenshot("music");
    }

    @Then("Select the Trending seller {string}")
    public void selectTheTrendingSeller(String arg0) {
        loginPage.tred();
        screenShot.takescreenshot("trend product");


    }

    @Then("Add WishList")
    public void addWishList() {
        loginPage.wishlist();
        screenShot.takescreenshot("wish List");

    }

    @Then("Add Cart")
    public void addCart() throws InterruptedException {
        Thread.sleep(40000);
        loginPage.cart();
        screenShot.takescreenshot("cart");
    }

    @Then("Go to Cart")
    public void goToCart() throws InterruptedException {
        Thread.sleep(40000);
        loginPage.gotocart();
        screenShot.takescreenshot(" go to cart");
    }
}
