package resources;

import BDD.pojo.AddPlace;
import BDD.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(){

        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 09");
        p.setLanguage("French-IN");
        p.setPhoneNumber("(+91) 983 893 3937");
        p.setWebsite("http://google.com");
        p.setName("Frontline house");
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
}
