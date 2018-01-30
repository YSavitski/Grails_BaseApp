package mapping

import grails.validation.Validateable


class User implements Validateable {
    String username
    String role

    static constraints = {
        username(nullable: false, blank: false)
        role(nullable: false, blank: false)
    }
}
