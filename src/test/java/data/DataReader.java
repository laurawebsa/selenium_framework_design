package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
    //Read JSON to string
    String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
            "//src//test//java//data//PurchaseOrder.json"), "UTF-8");

    //String to HashMap with Jackson Datbind
    ObjectMapper mapper = new ObjectMapper();
    List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
    });
    return data;
    }
}
