package rewards

import authority.Role
import authority.UserDetails
import authority.UserRole
import grails.gorm.transactions.Transactional
import mapping.User

@Transactional
class UserService {

    def createNewUser(User user) {
        UserDetails authUser = new UserDetails()
        authUser.username = user.username
        authUser.password = user.username
        authUser.save()

        UserRole.create(authUser, Role.findByAuthority(user.role))
    }
}
