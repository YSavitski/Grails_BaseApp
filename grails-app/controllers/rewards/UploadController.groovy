package rewards

import com.xlson.groovycsv.CsvParser

class UploadController {
    private List<Business> listBusinesses = new ArrayList<>()

    def index() { }

    def uploadFile() {

        def fileData = request.getFile('file')
        BufferedReader br = new BufferedReader(new InputStreamReader(fileData.inputStream))
        def csvData = CsvParser.parseCsv(br)
        int counter = 0;
        csvData.each {
            counter++;
            listBusinesses.add(new Business(it.TaxRegionName, Double.valueOf(it.Latitude), Double.valueOf(it.Longitude)).save())
        }

        render "Success uploaded " + counter + " businesses"
    }

    def showBusinesses() {
        [listBusinesses: listBusinesses]
    }












}
