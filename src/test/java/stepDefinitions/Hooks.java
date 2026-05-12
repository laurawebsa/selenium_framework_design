package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.那么;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
    StepDefinitions sd = new StepDefinitions();

    if(sd.placeId==null) {
        sd.add_place_payload("Karla", "Italian", "Europe");
        sd.user_calls_with_http_request("addPlaceApi", "POST");
        sd.verify_place_id_created_maps_to_using("Karla", "getPlaceApi");
       }
    }
}
