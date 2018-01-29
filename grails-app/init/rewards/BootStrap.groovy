package rewards

import authority.Role
import authority.User
import authority.UserRole
import grails.plugin.springsecurity.SpringSecurityService

class BootStrap {
    def SpringSecurityService springSecurityService

    def init = { servletContext ->
        new Product(name: "Morning Blend", sku: "MB01", price: 14.95).save()
        new Product(name: "Dark Roast", sku: "DK01", price: 12.95).save()
        new Customer(phone: 8015551212, firstName: "Luther", lastName: "Allison", email: "LAllison@gmail.com", totalPoints: 1).save()
        new Customer(phone: 2135551212, firstName: "Bessie", lastName: "Brown", email: "BBrown@gmail.com", totalPoints: 2).save()
        new Customer(phone: 6055551212, firstName: "Bo", lastName: "Diddley", email: "BDidley@gmail.com", totalPoints: 3).save()
        new Customer(phone: 6165551212, firstName: "Leroy", lastName: "Foster", email: "LFoster@gmail.com", totalPoints: 4).save()
        new Customer(phone: 8015554321, firstName: "Earl", lastName: "Hooker", email: "EHooker@gmail.com", totalPoints: 5).save()
        new Customer(phone: 7315551212, firstName: "Maggie", lastName: "Jones", email: "MJones@gmail.com", totalPoints: 5).save()
        new Customer(phone: 8185551212, firstName: "Nick", lastName: "Moss", email: "NMoss@gmail.com", totalPoints: 4).save()
        new Customer(phone: 7085551212, firstName: "Odie", lastName: "Payne", email: "OPayne@gmail.com", totalPoints: 3).save()
        new Customer(phone: 4155551212, firstName: "Jonny", lastName: "Shines", email: "JShines@gmail.com", totalPoints: 2).save()
        new Customer(phone: 7225551212, firstName: "Ethel", lastName: "Waters", email: "EWaters@gmail.com", totalPoints: 1).save()
        new Customer(phone: 6045551212, firstName: "Scrapper", lastName: "Blackwell", email: "SBlackwell@gmail.com", totalPoints: 1).save()
        new Customer(phone: 7315551122, firstName: "Archie", lastName: "Edwards", email: "AEdwards@gmail.com", totalPoints: 2).save()
        new Customer(phone: 5145551212, firstName: "Jessie", lastName: "Fuller", email: "JFuller@gmail.com", totalPoints: 3).save()
        new Customer(phone: 4085551212, firstName: "Ida", lastName: "Goodson", email: "IGoodson@gmail.com", totalPoints: 4).save()
        new Customer(phone: 8015551234, firstName: "Bumble Bee", lastName: "Smith", email: "BBSmith@gmail.com", totalPoints: 5).save()
        new Customer(phone: 4315551212, firstName: "Sippie", lastName: "Wallace", email: "SWallase@gmail.com", totalPoints: 4).save()

        new Client(name: "ManUtd", email: "accessibility@manutd.co.uk", street: "Sir Matt Busby Way, Stretford, Manchester", zip: "M16 0RA", latitude: 53.462949, longitude: -2.288996).save()
        new Client(name: "Old Trafford Cricket Ground", email: "test@gmail.com", street: "Talbot Rd, Stretford, Manchester", zip: "M16 0PX", latitude: 53.456435, longitude: -2.286808).save()

        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        def me = new User('admin', 'admin').save()
        def user = new User('user', 'user').save()

        UserRole.create(me, adminRole)
        UserRole.create(user, userRole)
        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
