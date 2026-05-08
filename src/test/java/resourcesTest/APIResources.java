package resourcesTest;

//enum special class in java which has collection of constants and methods
public enum APIResources {

    addPlaceApi("/maps/api/place/add/json"),
    getPlaceApi("/maps/api/place/get/json"),
    deletePlaceApi("/maps/api/place/delete/json");
    private String resource;

    APIResources(String resource){

        this.resource= resource;
    }

    public String getResource(){
        return resource;
    }
}
