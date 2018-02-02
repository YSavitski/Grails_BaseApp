package rewards

import com.google.gson.JsonObject
import com.google.gson.JsonParser

import java.nio.charset.StandardCharsets

class CoordinatesService {
    def getByAddress(Client client) {
        String searchAddress = String.join(", ", client.street, client.zip)
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

            JsonObject location = parseLocation(full)
            client.latitude = location.get("lat").asDouble
            client.longitude = location.get("lng").asDouble

            conn.disconnect()
            return client
        }
        catch (MalformedURLException e) {
            e.printStackTrace()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }

    def parseLocation(String json) {
        return new JsonParser().parse(json).results[0].geometry.location
    }
}
