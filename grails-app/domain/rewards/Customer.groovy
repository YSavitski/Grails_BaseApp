package rewards

class Customer {
    String firstName
    String lastName
    String phone
    String email
    Integer totalPoints

    static hasMany = [awards:Award, orders:OnlineOrder]

    static constraints = {
        phone(nullable: false, matches: "\\+[0-9]{12}|^\\s*\$")
        firstName nullable: true
        lastName nullable: true
        email(nullable: true, size: 4..100, email: true)
        totalPoints(nullable: true, max: 10)
    }
}
