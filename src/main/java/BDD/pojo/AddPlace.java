package BDD.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AddPlace {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("accuracy")
    private int accuracy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("address")
    private String address;
    @JsonProperty("types")
    private List<String> type;
    @JsonProperty("website")
    private String website;
    @JsonProperty("language")
    private String language;

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<String> getType() {
        return type;
    }
    public void setType(List<String> type) {
        this.type = type;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

}
