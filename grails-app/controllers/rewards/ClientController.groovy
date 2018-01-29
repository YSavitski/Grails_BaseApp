package rewards

class ClientController {
    static scaffold = Client

    def CoordinatesService coordinatesService

    def index() {
        Client.list().each {
            coordinatesService.getByAddress(it.street, it.zip)
        }

        [clients: Client.list()]
    }

    def create() {
        [clientInstance: new Client()]
    }
}
