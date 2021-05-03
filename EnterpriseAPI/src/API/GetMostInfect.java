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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author REMS1DE
 */
public class GetMostInfect {
    
    public void getMostCovid() throws MalformedURLException, IOException, JSONException {
        String url = "https://covid19.th-stat.com/api/open/cases/sum";
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
        
        System.out.println("-- Top 3 City most infected in Thailand--\n");
        System.out.println("Samut Sakhon- " + myResponse.getJSONObject("Province").getInt("Samut Sakhon"));
        System.out.println("Bangkok - " + myResponse.getJSONObject("Province").getInt("Bangkok"));
        System.out.println("Chonburi - " + myResponse.getJSONObject("Province").getInt("Chonburi"));
        System.out.println("\n============================================\n");
        
        
    }
}
