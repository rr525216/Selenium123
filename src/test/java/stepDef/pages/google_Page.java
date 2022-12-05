package stepDef.pages;

import com.functions.factory.drivers;
import com.pages.LoginPage;
import com.functions.util.ConfigReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stepDef.utilities.screenShot;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class google_Page {

    private ConfigReader configReader = ConfigReader.getInstance();
    private LoginPage loginPage = LoginPage.getInstance();
    private screenShot screenshot = screenShot.getInstance();
    private drivers driversLaunch = drivers.getInstance();
    public WebDriver driver;


    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        //  launch
        driver = driversLaunch.driverLaunch();

        //POM page
        loginPage.loginPage(driver);

        //launch URL
        loginPage.pageLogin(configReader.getValue("Url"));

        addTestStepLog("test start");
        screenshot.takescreenshot("login");
        screenshot.fieldname("field pass");

    }

    @And("User click Best")
    public void userClickBest() {
        loginPage.best();
        screenshot.takescreenshot("best seller");
    }

    @Then("test fail")
    public void testFail() {
        Assert.fail();
    }

    @And("user click Best Seller {string}")
    public void userClickBestSeller(String arg0) {
        loginPage.bestselleproduct();
        screenshot.takescreenshot("bestseller product");
    }

    @And("user click Best Seller in {string}")
    public void userClickBestSellerIn(String arg0) {
        loginPage.music();
        screenshot.takescreenshot("music");
    }

    @Then("Select the Trending seller {string}")
    public void selectTheTrendingSeller(String arg0) {
        loginPage.tred();
        screenshot.takescreenshot("trend product");


    }

    @Then("Add WishList")
    public void addWishList() throws InterruptedException {
        loginPage.wishlist();
        screenshot.takescreenshot("wish List");

    }

    @Then("Add Cart")
    public void addCart() throws InterruptedException {
        Thread.sleep(40000);
        loginPage.cart();
        screenshot.takescreenshot("cart");
    }

    @Then("Go to Cart")
    public void goToCart() throws InterruptedException {
        Thread.sleep(40000);
        loginPage.gotocart();
        screenshot.takescreenshot(" go to cart");
    }

    @Given("User get the DATA")
    public void userGetTheDATA() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("https://demoqa.com/BookStore/v1/Books");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode , 200,   "Correct status code returned");
        System.out.println(response.prettyPrint());

    }
}
