package resourcesTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.*;
import java.util.*;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        //control when there are more information to Examples feature
        if(req==null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        InputStream file = getClass().getClassLoader().getResourceAsStream("global.properties");
        prop.load(file);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key){

        String resp  = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();

    }
}
