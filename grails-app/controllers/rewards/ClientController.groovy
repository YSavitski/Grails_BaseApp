package rewards

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

class ClientController {
    static scaffold = Client

    ClientService clientService

    UploadClientsService uploadClientsService

    @Secured(['ROLE_USER','ROLE_ADMIN'])
    def index() {
        [clients: Client.list()]
    }

    @Secured('ROLE_ADMIN')
    def create() {
        [clientInstance: new Client()]
    }

    @Secured('ROLE_ADMIN')
    def upload() {
        render uploadClientsService.upload(request)
    }

    @Secured('ROLE_ADMIN')
    def save(Client client) {
        if (client == null) {
            notFound()
            return
        }

        try {
            clientService.save(client)
        } catch (ValidationException e) {
            respond client.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'client.label', default: 'Client'), client.id])
                redirect client
            }
            '*' { respond client, [status: CREATED] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'client.label', default: 'Client'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
