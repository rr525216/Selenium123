package stepDef.pages;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class basicREST {
    @Given("User get the DATA")
    public void userGetTheDATA() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("https://demoqa.com/BookStore/v1/Books");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode , 200,   "Correct status code returned");
        System.out.println(response.prettyPrint());

    }
}
