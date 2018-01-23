package rewards

class Product {

    String name
    String sku
    Float price
    static hasMany = [orderItems:OrderItem]

    static constraints = {
        name(nullable: false)
        sku(nullable: false)
        price(nullable: false)
    }
}
