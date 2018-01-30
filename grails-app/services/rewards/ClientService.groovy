package rewards

import grails.gorm.services.Service
import org.springframework.transaction.annotation.Transactional

@Service(Client)
@Transactional
class ClientService {
    CoordinatesService coordinatesService

    Client get(Serializable id) {
        return Client.findById(id)
    }

    Client save(Client client) {
        client = coordinatesService.getByAddress(client)
        client.save()
    }
}
