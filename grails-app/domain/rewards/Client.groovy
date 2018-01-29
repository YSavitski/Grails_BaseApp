package rewards

class Client {
    String name
    String email
    String street
    String zip
    Double latitude
    Double longitude



    static constraints = {
        name(nullable: false, unique: true)
        email(nullable: false, email: true)
        street(nullable: true)
        zip(nullable: true)
        latitude(nullable: true)
        longitude(nullable: true)
    }
}
