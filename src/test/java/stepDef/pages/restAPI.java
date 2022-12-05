package stepDef.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import stepDef.utilities.screenShot;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class restAPI {

    public Response response;

    public screenShot screenShot = stepDef.utilities.screenShot.getInstance();

    @Given("User get the DATA")
    public void user_get_the_data() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get("https://demoqa.com/BookStore/v1/Books");
        addTestStepLog(response.prettyPrint());
        screenShot.fieldname(response.prettyPrint());


    }


    @Then("Response Code {int}")
    public void responseCode(int code) {
        Assert.assertEquals(response.getStatusCode() ,code);
        addTestStepLog(String.valueOf(response.getStatusCode()));
        screenShot.fieldname(String.valueOf(response.getStatusCode()));
    }
}
