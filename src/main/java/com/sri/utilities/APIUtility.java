package com.sri.utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by srinidhis on 21/08/16.
 */
public class APIUtility {
    private static Gson gson = new Gson();

    /*Utility method to convert json input to dto object
    * json - The input json as String
    * Type -  Dynamic Type
    * Usage : APIUtility.convertJsonToDTO(response, new TypeToken<RepositoryDTO>() {}.getType());*/

    public static Object convertJsonToDTO(String json , Type type){
        System.out.println("Converting Json input to " + type.getClass().getCanonicalName() + " Object ");
        Object containerObject = null;
        System.out.println("Json is - " + json);
        try {
            containerObject = gson.fromJson(json, type);
        }
        catch (Exception ex)
        {
            System.out.println("Failed to covert JSON to " + type.getClass().getCanonicalName());
            ex.printStackTrace();
        }
        return containerObject;
    }

    //Utility method to get the response as string
    public static String getResponseAsString(InputStream inputStream){
        StringBuilder messageBuilder=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String output;
        System.out.println("Output from Server .... \n");
        try {
            while ((output = br.readLine()) != null) {
                messageBuilder.append(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response=messageBuilder.toString();
        return response;
    }

    //Method to do a get request call
    public static HttpURLConnection sendGetRequest(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        return conn;
    }
}
