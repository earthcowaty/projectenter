/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseapi;

import API.GetDailyCovid;
import API.GetMostInfect;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author REMS1DE
 */
public class EnterpriseAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, JSONException {
        GetDailyCovid daily = new GetDailyCovid();
        GetMostInfect most = new GetMostInfect();
        daily.getAPICovid();
        most.getMostCovid();
    }
    
}
