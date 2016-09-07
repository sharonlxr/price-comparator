package com.example.sharonlxr.ilovenougat;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sharonlxr on 9/5/16.
 */
public class pmQuery extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... params) {
        try {
            String  prefix="https://api.6pm.com/Search?term=";
            String  postfix = "&key=524f01b7e2906210f7bb61dcbe1bfea26eb722eb" ;
            String term = params[0];
            String apirul= prefix+term+postfix;
            URL url = new URL(apirul);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                String jsonstring =  stringBuilder.toString();

                JSONObject json = (JSONObject)new JSONObject(jsonstring);

                return json;

            } finally {
                urlConnection.disconnect();
            }


        } catch (Exception e) {
            return null;
//            try{
//            JSONObject js=  new JSONObject(e.toString());
//                return js;}catch (Exception err){
//                return null;
//            }

        }


    }

    @Override
    protected void onPostExecute(JSONObject list) {

    }
}
