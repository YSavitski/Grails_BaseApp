package rewards

import com.xlson.groovycsv.CsvParser
import grails.gorm.transactions.Transactional

import javax.servlet.http.HttpServletRequest

@Transactional
class UploadClientsService {
    ClientService clientService

    def upload(HttpServletRequest request) {
        def fileData = request.getFile('file')
        BufferedReader br = new BufferedReader(new InputStreamReader(fileData.inputStream))
        def csvData = CsvParser.parseCsv(br)
        int counter = 0
        csvData.each {
            counter++
            clientService.save(new Client(it.Name, it.Email, it.Street, it.Zip))
        }
        return "Success uploaded " + counter + " clients"
    }
}
