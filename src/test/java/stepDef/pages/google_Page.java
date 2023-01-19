package stepDef.pages;

import com.functions.factory.MobileDriverFactory;
import com.functions.factory.drivers;
import com.functions.util.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import stepDef.pomPages.LoginPage;
import stepDef.pomPages.MobilePage;
import stepDef.utilities.screenShot;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class google_Page {

    public WebDriver driver;
    public MobilePage mobilePage;
    public MobileDriverFactory mobileDriverFactory = new MobileDriverFactory();
    private final ConfigReader configReader = ConfigReader.getInstance();
    private final LoginPage loginPage = LoginPage.getInstance();
    private final screenShot screenshot = screenShot.getInstance();
    private final drivers driversLaunch = drivers.getInstance();

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {

        //  launch
        driver = driversLaunch.driverLaunch();

        //POM page
        loginPage.LoginPage(driver);

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

        screenshot.takeElementScreenShot("element screenshot", loginPage.bestsellerss);
    }

    @Then("test fail")
    public void testFail() {
        Assert.fail();
    }

    @And("user click Best Seller {string}")
    public void userClickBestSeller(String arg0) throws InterruptedException {
        loginPage.bestselleproduct();
        screenshot.takescreenshot("bestseller product");
    }

    @And("user click Best Seller in {string}")
    public void userClickBestSellerIn(String arg0) throws InterruptedException {
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


    @And("Window Handle")
    public void windowHandle() {

// Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);

// Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);

    }

    @And("User Click the Mobiles")
    public void userClickTheMobiles() throws InterruptedException {

        Thread.sleep(2000);
        WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobiles']"));
        mobile.click();

        Thread.sleep(2000);
        WebElement mobilec = driver.findElement(By.xpath("//span[text()='Samsung']/preceding::i[1]"));
        mobilec.click();


        //span[starts-with(text(),'Samsung Galaxy M13 (Aqua Green, 6GB')]

        Thread.sleep(3000);

        WebElement mobiles = driver.findElement(By.xpath("//span[starts-with(text(),'Samsung Galaxy M13 (Aqua Green, 6GB')]"));
        mobiles.click();


        // It will return the parent window name as a String
        String parent = driver.getWindowHandle();

        Set<String> s = driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();
        String child_window = I1.next();

        if (!parent.equals(child_window)) {
            driver.switchTo().window(child_window);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Driver iii " + driver.getTitle());

            // driver.close();

        }


        while (I1.hasNext()) {


        }

        Thread.sleep(5000);
        try {
            WebElement add1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
            add1.click();
        } catch (Exception e) {
            JavascriptExecutor javascriptExecutor = null;
            WebElement add1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));

            javascriptExecutor.executeScript("arguments[0].click();", add1);
        }

        driver.switchTo().window(parent);


    }

    @Given("Open multi windows")
    public void openMultiWindows() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        //open new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.navigate().to("https://www.lambdatest.com/");

        driver.quit();
    }

    @Given("Open MultiTabs")
    public void openMultiTabs() {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com/");

        //open new TAB
        // driver.switchTo().newWindow(WindowType.TAB);

        //driver.navigate().to("https://www.lambdatest.com/");

        //  driver.quit();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());


        for (int i = 0; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.get(i));


        }

        driver.navigate().to("https://www.lambdatest.com/");

    }

    @Given("launch App")
    public void launchApp() throws MalformedURLException, InterruptedException {

        //Driver launch
        driver = mobileDriverFactory.mobileDriverLaunch();

        //driver passing the MobilePage
        mobilePage = new MobilePage(driver);
        ConfigReader.setDriver("driver", driver);
        screenshot.takescreenshot("Home Page");
        mobilePage.click_button();


    }
}
