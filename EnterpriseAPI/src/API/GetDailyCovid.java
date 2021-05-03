/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author REMS1DE
 */
public class GetDailyCovid {

    public void getAPICovid() throws MalformedURLException, IOException, JSONException {
        String url = "https://covid19.th-stat.com/api/open/today";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent","");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("-- Covid 19 Infected Update --\n");
        System.out.println("Confirmed- " + myResponse.getInt("Confirmed"));
        System.out.println("Recovered- " + myResponse.getInt("Recovered"));
        System.out.println("Hospitalized- " + myResponse.getInt("Hospitalized"));
        System.out.println("Deaths- " + myResponse.getInt("Deaths"));
        System.out.println("NewConfirmed- " + myResponse.getInt("NewConfirmed"));
        System.out.println("NewRecovered- " + myResponse.getInt("NewRecovered"));
        System.out.println("NewHospitalized- " + myResponse.getInt("NewHospitalized"));
        System.out.println("NewDeaths- " + myResponse.getInt("NewDeaths"));
        System.out.println("UpdateDate- " + myResponse.getString("UpdateDate"));
        System.out.println("\n============================================\n");
    }

}
