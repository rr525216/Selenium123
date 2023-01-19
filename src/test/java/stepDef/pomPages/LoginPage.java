package stepDef.pomPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {


    private WebDriver driver;

    private static LoginPage loginPage = null;

    private JavascriptExecutor javascriptExecutor;

    private WebDriverWait wait;

    private Actions actions;


    private LoginPage() {
    }

    public static LoginPage getInstance() {

        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


    //POM
    private By bestseller = By.xpath("(//a[contains(text(),'Best Sellers')])[1]");
    private By bestselleproduct = By.xpath("//a[contains(text(),'Software')]");
    private By music = By.xpath("//span[contains(text(),'Software')]/following::a[contains(text(),'Music')][1]");
    private By prodOne = By.xpath("(//span[starts-with(text(),'#1')])[1]");
    private By tred = By.xpath("(//span[starts-with(text(),'#1')])[1]/following::a[2]");
    private By wishlist = By.xpath("//a[contains(text(),'Add to Wish List')]");
    private By cart = By.xpath("//span[contains(text(),'Add to Cart')]");
    private By gotocart = By.xpath("(//a[contains(text(),'Go to Cart')])[2]");

    //Page Factory
    public void LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javascriptExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//span[starts-with(text(),'#1')])[1]")
    WebElement productsOne;

    @FindBy(xpath = "//a[contains(text(),'Add to Wish List')]")
    WebElement wishlists;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    WebElement carts;

    @FindBy(xpath = "(//a[contains(text(),'Best Sellers')])[1]")
    public
    WebElement bestsellerss;

    @FindBy(xpath = "(//span[starts-with(text(),'#1')])[1]/following::a[2]")
    WebElement trends;

    @FindBy(xpath = "//a[contains(text(),'Software')]")
    WebElement bestSellers;

    @FindBy(xpath = "//span[contains(text(),'Software')]/following::a[contains(text(),'Music')][1]")
    WebElement Music;


    public void best() {
        bestsellerss.click();

    }

    public void pageLogin(String url) {

        driver.get(url);

    }

    public void bestselleproduct() throws InterruptedException {
        //driver.findElement(bestselleproduct).click();
        Thread.sleep(2000);
        actions.moveToElement(bestSellers).click().build();
        //javascriptExecutor.executeScript("arguments[0].click();", bestselleproduct);
    }

    public void music() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(Music).click().build();
    }

    public void prodOne() throws InterruptedException {

        Thread.sleep(3000);
        //driver.findElement(prodOne).click();
        javascriptExecutor.executeScript("arguments[0].click();", productsOne);
    }

    public void tred() {

        javascriptExecutor.executeScript("arguments[0].click();", trends);
    }

    public void wishlist() throws InterruptedException {

       // Thread.sleep(2000);
       // wishlists.click();

//        Action mouseOverHome = actions
//                .moveToElement(wishlists)
//                .click()
//                .build();
        actions.moveToElement(wishlists).click().build();
       // wait.until(ExpectedConditions.elementToBeClickable(wishlists)).click();
        //javascriptExecutor.executeScript("arguments[0].click();", wishlists);

    }

    public String cart() throws InterruptedException {

        javascriptExecutor.executeScript("arguments[0].click();", carts);
        String txt = carts.getText();
        return txt;

    }

    public void gotocart() {
        WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]"));
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

}
