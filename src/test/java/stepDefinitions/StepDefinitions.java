package stepDefinitions;

import BDD.pojo.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions extends Utils {

    RequestSpecification res;
    ResponseSpecification res_spec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add place payload")
    public void add_place_payload() throws FileNotFoundException {

        res = given().spec(requestSpecification()).body(data.addPlacePayload());

    }

    @When("User calls {string} with POST http request")
    public void user_calls_with_http_request(String string) {
        res_spec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        response = res.when().post("/maps/api/place/add/json").
                then().spec(res_spec).extract().response();
    }

    @Then("The API call is successful with status code {int}")
    public void the_api_call_is_successful_with_status_code(int statusCode) {
        assertEquals(200, response.getStatusCode());
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is_ok(String keyValue, String expectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(keyValue).toString(), expectedValue);
    }
}