package stepDef.pages;

import com.functions.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import stepDef.utilities.screenShot;

import java.util.*;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class restAPI {

    public Response response;

    public screenShot screenShot = stepDef.utilities.screenShot.getInstance();

    List<String> ss = new ArrayList<>();
    List<String> ss1 = new ArrayList<>();
   HashMap st = new HashMap();

    public JsonPath jsonPath;

    @Given("User get the DATA")
    public void user_get_the_data() {


        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

        String url = "/Books";

        response = RestAssured.given().when().get(url);

        System.out.println("total Response : " + response.prettyPrint());

        screenShot.fieldname("total Response : " + response.prettyPrint());

        jsonPath = response.jsonPath();

        HashMap a2 = null;

        int l2;

//books
        List<String> bb = jsonPath.get("books");

        for (l2 = 0; l2 < bb.size(); l2++) {

            a2 = new HashMap(jsonPath.getJsonObject("books[" + l2 + "]"));
            System.out.println("book " + a2 + "\n");

            if (bb.size() != 0) {
                if (a2 != null) {

                    st.put(l2,a2);


                } else if (a2 == null) {
                    break;
                }
            } else if (bb.size() == 0) {
                break;
            }

        }

        ConfigReader.setConfigValue("hshkey", String.valueOf(st.get(0)));

        ///////author

        List<String> ll = jsonPath.get("books.author");

        for (int l = 0; l < ll.size(); l++) {

            String a1 = jsonPath.get("books.author[" + l + "]");
            System.out.println(a1+ "\n");

            if (ll.size() != 0) {
                if (a1 != null) {
                    ss.add(a1);
                } else if (a1 == null) {
                    break;
                }
            } else if (ll.size() == 0) {
                break;
            }

        }

        ConfigReader.setConfigValue("one", ss.get(1)+ "\n");


       for (int k=0;k< ss.size();k++){

           ss.get(k);

           if(("Axel Rauschmayer").equals(ss.get(k))){
               System.out.println("name equals : " +ss.get(k));
               ss.clear();
               break;
           }
       }

    }


    @Then("Response Code {int}")
    public void responseCode(int code) {

        System.out.println("name  "+ ConfigReader.getConfigValue("one"));

        System.out.println("hashhh : " + ConfigReader.getConfigValue("hshkey"));

        Assert.assertEquals(response.getStatusCode(), code);
        addTestStepLog(String.valueOf(response.getStatusCode()));
        screenShot.fieldname("Status Code : " +String.valueOf(response.getStatusCode()));
    }


}
