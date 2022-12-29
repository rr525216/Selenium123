package stepDef.pages;

import com.functions.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import stepDef.utilities.screenShot;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

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

        response = RestAssured.given().when().get("url");

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

                    st.put(l2, a2);

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
            System.out.println(a1 + "\n");

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

        ConfigReader.setConfigValue("one", ss.get(1) + "\n");


        for (int k = 0; k < ss.size(); k++) {

            ss.get(k);

            if (("Axel Rauschmayer").equals(ss.get(k))) {
                System.out.println("name equals : " + ss.get(k));
                ss.clear();
                break;
            }
        }

    }


    @Then("Response Code {int}")
    public void responseCode(int code) {

        System.out.println("name  " + ConfigReader.getConfigValue("one"));

        System.out.println("hashhh : " + ConfigReader.getConfigValue("hshkey"));

        Assert.assertEquals(response.getStatusCode(), code);
        addTestStepLog(String.valueOf(response.getStatusCode()));
        screenShot.fieldname("Status Code : " + String.valueOf(response.getStatusCode()));
    }


    @Given("User get the DATA in backend")
    public void userGetTheDATAInBackend() {

        response = RestAssured.given().get("https://rapidapi.com/learn/api/rest");


        Assert.assertEquals(200, response.getStatusCode());

        System.out.println("Status Code : " + response.getStatusCode() + "\n");

        System.out.println("Response : " + response.prettyPrint() + "\n");


        response.body().jsonPath().get("data[1]");

        System.out.println("data name : " + response.body().jsonPath().get("data.first_name").toString());

        jsonPath = response.jsonPath();

        List<String> names = jsonPath.getJsonObject("data.first_name");

        // System.out.println("names : " + names.get(1));

        int i = 1;
        for (String nm : names) {

            System.out.println("name_0" + i + " : " + nm);

            i++;
        }


        // response = RestAssured.given().post("https://rapidapi.com/learn/api/rest");
    }

    @Given("User POST the DATA in backend")
    public void userPOSTTheDATAInBackend() {


        JSONObject request = new JSONObject();

        // "id": "9",
//                "first_name": "Elias",
//                "last_name": "Kilback",
//                "email": "Elias.Kilback89@hotmail.com"

        request.put("first_name", "Elias11");
        request.put("last_name", "Kilback_11");
        request.put("email", "Elias.Kilback89_11@hotmail.com");

        System.out.println(request.toJSONString());

        baseURI = "https://rapidapi.com/learn/api/";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("rest");


        System.out.println("########--responses##########" + "\n");
        System.out.println("post code : " + response.getStatusCode() + "\n");
        System.out.println("responses : " + response.prettyPrint() + "\n");

    }


    @Given("User PUT the DATA in backend")
    public void userPUTTheDATAInBackend() {

        JSONObject request = new JSONObject();

        // "id": "9",
//                "first_name": "Elias",
//                "last_name": "Kilback",
//                "email": "Elias.Kilback89@hotmail.com"

        request.put("first_name", "naveenReddy");
        request.put("last_name", "Kilback_11");
        request.put("email", "Elias.Kilback89_11@hotmail.com");

        System.out.println(request.toJSONString());

        baseURI = "https://rapidapi.com/learn/api/";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("rest/5");


        System.out.println("########--responses##########" + "\n");
        System.out.println("put code : " + response.getStatusCode() + "\n");
        System.out.println("responses : " + response.prettyPrint() + "\n");


    }

    @Given("User PATCH the DATA in backend")
    public void userPATCHTheDATAInBackend() {


        JSONObject request = new JSONObject();

        request.put("first_name", "naveenReddy");

        System.out.println(request.toJSONString());

        baseURI = "https://rapidapi.com/learn/api/";

        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("rest/5");


        System.out.println("########--responses##########" + "\n");
        System.out.println("put code : " + response.getStatusCode() + "\n");
        System.out.println("responses : " + response.prettyPrint() + "\n");
    }

    @Given("LocalHost Launch")
    public void localhostLaunch() {

        baseURI = "http://localhost:3000/";

        response = given().get("books");

        System.out.println( " \"Status code\" : " + response.getStatusCode());
        System.out.println(" \"Response Body\" : " +  response.prettyPrint());


        //      baseURI = "https://reqres.in/";
//
//        response = given()
//                .when()
//                .headers("email","eve.holt@reqres.in")
//                .headers("password","pistol")
//                .post("api/register");




//        JSONObject requestParams = new JSONObject();
//        requestParams.put("email", "eve.holt@reqres.in");
//       requestParams.put("password", "pistol");

//        HashMap<String, String> params1 = new HashMap<String, String>();
//        params1.put( "email", "eve.holt@reqres.in");
//        params1.put( "password", "pistol");
//
//
//
//        JSONObject json1 = new JSONObject(params1);
//
//        System.out.println(json1.toString());
//
////        response = given()
////                .body(json1.toJSONString()).with()
////              //  .body(json2.toJSONString())
////                .post("https://reqres.in/api/register");
//
//
//        response = given()
//                .when()
//                .body(json1.toJSONString())
//                .when()
//                .post("https://reqres.in/api/register");
//
//        System.out.println(" \"Response Body\" : " +  response.prettyPrint());

    }
}
