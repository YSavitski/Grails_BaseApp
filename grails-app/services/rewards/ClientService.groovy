package rewards

import grails.gorm.transactions.Transactional

@Transactional
class ClientService {
    CoordinatesService coordinatesService

    Client save(Client client) {
        client = coordinatesService.getByAddress(client)
        client.save()
    }
}
