package testrunners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.*;

@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/Cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                //"timeline:test-output-thread/"
        },
        monochrome = true,
        features = {"features"},
        glue = {"stepDef"},
        dryRun = false,
        tags = "@Appium"
)

public class ParallelRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}