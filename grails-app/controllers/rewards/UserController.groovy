package rewards

import authority.Role
import grails.validation.ValidationException
import grails.web.Controller
import mapping.User

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

@Controller
class UserController {
    UserService userService

    def index() {
        clientController.index()
    }

    def create() {
        List<String> roles = Role.list()
                .stream()
                .map({auth -> auth.authority})
                .collect()

        [user: new User(), roles: roles]
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }

        if (user.hasErrors()) {
            respond user.errors, view:'create'
            return
        }

        try {
            userService.createNewUser(user)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'user.create.message', args: [user.username, user.role])
                redirect controller: 'client', action: 'index'
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    protected void notFound(User user) {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.null.message', args: [user.role])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
