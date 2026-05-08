package resourcesTest;

import BDD.pojo.AddPlace;
import BDD.pojo.Location;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name, String language, String address) throws IOException {

        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhoneNumber("(+91) 983 893 3937");
        p.setWebsite("http://google.com");
        p.setName(name);
        List<String> typeList=new ArrayList<String>();
        typeList.add("shoe park");
        typeList.add("shop");
        p.setType(typeList);
        Location loc = new Location();
        p.setLocation(loc);
        loc.setLatitude(-38.383494);
        loc.setLongitude(33.427362);
        return p;

    }

    public String deletePlacePayload(String placeId) throws IOException {

        return "{\r\n \"place_id\": \""+placeId+"\"\r\n}";
    }
}
