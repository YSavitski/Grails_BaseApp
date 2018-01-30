package rewards

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

class ClientController {
    static scaffold = Client

    ClientService clientService

    UploadClientsService uploadClientsService

    def index() {
        [clients: Client.list()]
    }

    def show(Long id) {
        [client: clientService.get(id)]
    }

    def create() {
        [client: new Client()]
    }

    def edit(Long id) {
        [client: clientService.get(id)]
    }

    def upload() {
        render uploadClientsService.upload(request)
    }

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
