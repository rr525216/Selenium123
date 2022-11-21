package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/parallel"},
		glue = {"stepDef"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"

				
		},
		tags = "@googlepage"
		
		)

public class MyTestRunner {

}
