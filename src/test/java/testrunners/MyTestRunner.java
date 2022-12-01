package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(

		plugin = {"pretty",
				"json:target/cucumber-reports/Cucumber.json",
				"html:target/cucumber-reports/Cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"timeline:test-output-thread/"

				
		},
		features = {"features"},
		glue = {"stepDef"},
		tags = "@AmazonProduct"
		
		)

public class MyTestRunner {

}
