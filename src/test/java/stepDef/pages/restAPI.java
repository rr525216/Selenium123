package stepDef.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class restAPI {

    public Response response;

    @Given("User get the DATA")
    public void user_get_the_data() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.get("https://demoqa.com/BookStore/v1/Books");
        addTestStepLog(response.prettyPrint());

    }

    @Then("Response Code {string}")
    public void responseCode(String code) {

        Assert.assertEquals(response.getStatusCode() ,code);
        addTestStepLog(response.prettyPrint());
    }

    @Then("Response Code {int}")
    public void responseCode(int code) {
        Assert.assertEquals(response.getStatusCode() ,code);
        addTestStepLog(String.valueOf(response.getStatusCode()));
    }
}
