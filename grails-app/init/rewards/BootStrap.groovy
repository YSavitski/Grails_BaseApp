package rewards

import authority.Role
import authority.UserDetails
import authority.UserRole

class BootStrap {
    def init = { servletContext ->
        new Client(name: "ManUtd", email: "accessibility@manutd.co.uk", street: "Sir Matt Busby Way, Stretford, Manchester", zip: "M16 0RA", latitude: 53.462949, longitude: -2.288996).save()
        new Client(name: "Old Trafford Cricket Ground", email: "test@gmail.com", street: "Talbot Rd, Stretford, Manchester", zip: "M16 0PX", latitude: 53.456435, longitude: -2.286808).save()

        def userRole = new Role('ROLE_USER').save()
        def adminRole = new Role('ROLE_ADMIN').save()

        def me = new UserDetails('admin', 'admin').save()
        def user = new UserDetails('user', 'user').save()

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
