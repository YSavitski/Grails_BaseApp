package rewards

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import grails.gorm.transactions.Transactional
import org.springframework.web.util.UriUtils

import java.nio.charset.StandardCharsets

@Transactional
class CoordinatesService {
    def getByAddress(String street, String zip) {
        String searchAddress = String.join(", ", street, zip)
        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +
                URLEncoder.encode(searchAddress, StandardCharsets.UTF_8.toString()) +
                "&key=AIzaSyBuVjBBrBoqib2cWPNg-LFuZadj2Fpe_0g")
        try {

            HttpURLConnection conn = (HttpURLConnection) url.openConnection()
            conn.setRequestMethod("GET")
            conn.setRequestProperty("Accept", "application/json")

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode())
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())))
            String output = "", full = ""
            while ((output = br.readLine()) != null) {
                System.out.println(output)
                full += output
            }

            conn.disconnect()
        }
        catch (MalformedURLException e) {
            e.printStackTrace()
        } catch (IOException e) {
            e.printStackTrace()
        } finally {

        }
    }

    def parseLatLng(String json) {
        JsonParser parser = new JsonParser()
        JsonObject location =  parser.parse(json).getAsJsonObject()
                .getAsJsonArray("results").get(0).getAsJsonObject()
                .getAsJsonObject("geometry")
                .getAsJsonObject("location")

        Double latitude = location.get("lat").asDouble
        Double longitude = location.get("lng").asDouble
        return [latitude, longitude]
    }
}
