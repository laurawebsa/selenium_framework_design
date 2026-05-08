package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;
import resourcesTest.APIResources;
import resourcesTest.TestDataBuild;
import resourcesTest.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions extends Utils {

    RequestSpecification res;
    ResponseSpecification res_spec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    String placeId;

    @Given("Add place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {

        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name,language,address));

    }

    @When("User calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        //Make it generic, ENUM constructor is executing
        APIResources resourceAPI = APIResources.valueOf(resource);
        String resourcePath = resourceAPI.getResource();

        res_spec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("POST")){
            response = res.when().post(resourcePath)
                    .then().spec(res_spec).extract().response();
        }else if(method.equalsIgnoreCase("GET")){
            response = res.when().get(resourcePath)
                    .then().spec(res_spec).extract().response();
        }
    }

    @Then("The API call is successful with status code {int}")
    public void the_api_call_is_successful_with_status_code(int statusCode) {
        assertEquals(200, response.getStatusCode());
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is_ok(String keyValue, String expectedValue) {
        //Declare a variable to keep place_id
        assertEquals(getJsonPath(response,keyValue), expectedValue);

    }
    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using
            (String expectedName, String resource) throws IOException {
        placeId = getJsonPath(response,"place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", placeId);
        user_calls_with_http_request(resource, "GET");
        String currentName = getJsonPath(response,"name");
        assertEquals(expectedName, currentName);
    }

    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
    }
}