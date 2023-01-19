package stepDef.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.utilities.screenShot;

import java.time.Duration;

public class MobilePage {

    private final screenShot screenshot = screenShot.getInstance();
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[@text='7']")
    WebElement SevenBTN;
    @FindBy(xpath = "//*[@text='x']")
    WebElement XBTN;
    @FindBy(xpath = "//*[@text='3']")
    WebElement ThreeBTN;
    @FindBy(xpath = "//*[@text='=']")
    WebElement eBTN;

    public MobilePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofMinutes(5));

    }

    public void click_button() {
        SevenBTN.click();
        screenshot.takescreenshot("7 Button clicked");
        screenshot.fieldname("7 Button clicked");

        XBTN.click();
        screenshot.takescreenshot("* Button clicked");
        screenshot.fieldname("* Button clicked");

        ThreeBTN.click();
        screenshot.takescreenshot("3 Button clicked");
        screenshot.fieldname("3 Button clicked");

        eBTN.click();
        screenshot.takescreenshot("= Button clicked");
        screenshot.fieldname("= Button clicked");

        //*[@class='android.widget.ImageButton']
    }


}
