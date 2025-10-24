/**
 * IST 411 Project
 * Author: Phillip Nguyen(Head Dev) & Alexander Platon
 * Description: Takes COVID-19 data from NovelAPI, stores it in an ArrayList, and returns the ArrayList 
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FillData {

    //variables
    String apiLink = "https://corona.lmao.ninja/v2/states?sort&yesterday";
    ArrayList<State> statesList;

    public FillData() throws IOException {
        statesList = new ArrayList<>();
    }

    public ArrayList<State> loadStatesToArrayList() throws IOException {

        String token = "d14cdaef3eb54818b38141658230902";

        //Opens URL connection then casts it to HttpURLConnection object
        HttpURLConnection con1 = (HttpURLConnection) new URL(apiLink).openConnection();
        //Requests GET message
        con1.setRequestMethod("GET");

        System.out.println("before try");

        //Converts URL to InputStream, then converts InputStream to Reader allowing for webpage data to be read
        try (InputStream is = con1.getInputStream(); Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            System.out.println("loading items try");
            //Instantiation of Gson object
            Gson gson = new Gson();

            //Converts any JSON object and array to Java object and ArrayList
            statesList = gson.fromJson(reader, new TypeToken<ArrayList<State>>(){}.getType());
            System.out.println("Loaded " + statesList.size() + " states from API to ArrayList");

            System.out.println("success");

        } catch (Exception e) {
            System.out.print("ERROR START");
            e.printStackTrace();
            System.out.print("ERROR STOP");
        }

        if (statesList == null) {
            statesList = new ArrayList<>();
        }
        return statesList;
    }
}
