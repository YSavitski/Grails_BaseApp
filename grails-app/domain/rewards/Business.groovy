package rewards

class Business {
    String name
    Double latitude
    Double longitude

    Business(String name, Double latitude, Double longitude) {
        this.name = name
        this.latitude = latitude
        this.longitude = longitude
    }
    static constraints = {
    }
}
