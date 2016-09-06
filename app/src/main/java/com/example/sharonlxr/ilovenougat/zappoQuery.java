package com.example.sharonlxr.ilovenougat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by sharonlxr on 9/2/16.
 */

public class zappoQuery extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... params) {
                JSONObject json;
                JSONArray results ;
                try {
                    final String prefix = "https://api.zappos.com/Search?term=";
                    final String postfix = "&key=b743e26728e16b81da139182bb2094357c31d331";
                    String term = params[0];
                    String apirul = prefix + term + postfix;
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
                        String jsonstring = stringBuilder.toString();

                        json = (JSONObject) new JSONObject(jsonstring);
                        results=json.getJSONArray("results");
                        urlConnection.disconnect();
//                        json.put("test","123");
//                try {
                   int i = 0;
                    while(!results.isNull(i)){
                        JSONObject jt = results.getJSONObject(i);

                        String image = jt.getString("thumbnailImageUrl");
                        String id = jt.getString("productId");
                        String title= id+"img";
                          String  pmpre="https://api.6pm.com/Search?term=";
                        String  postpm = "&key=524f01b7e2906210f7bb61dcbe1bfea26eb722eb" ;
                        String pm = pmpre+id+postpm;
                        url = new URL(pm);


                        URL url2 = new URL(image);

                        URLConnection urlcon = url2.openConnection();
                        Bitmap bt =BitmapFactory.decodeStream(urlcon.getInputStream());
                        json.put(title,bt);


                        i+=1;
                    }


                    } finally {
                        urlConnection.disconnect();
//                        try{
//                    //get same product info from 6pm
//                    int i =0;
//                    while(!results.isNull(i)){
//                    String  pmpre="https://api.6pm.com/Search?term=";
//                    String  postpm = "&key=524f01b7e2906210f7bb61dcbe1bfea26eb722eb" ;
//                        JSONObject jo = results.getJSONObject(i);
//                        String id = jo.getString("productId");
//
//                    String pm = pmpre+id+postpm;
//                    URL httpurl = new URL(pm);
//                    HttpURLConnection urlConnection2 = (HttpURLConnection) httpurl.openConnection();
//
//                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(urlConnection2.getInputStream()));
//                    StringBuilder stringBuilder2 = new StringBuilder();
//                    String line2;
//                    while ((line2 = bufferedReader2.readLine()) != null) {
//                        stringBuilder2.append(line2).append("\n");
//                    }
//                    json.put(id+"search",new JSONObject(stringBuilder2.toString()));
//                        i+=1;
//
//                    }
//                }catch (Exception e){
//                    try{
//                    JSONObject js = new JSONObject();
//                    js.put("error",e.toString());}catch (Exception err){
//                        return  null;
//                    }
//                }
                    }


                } catch (Exception e) {

                    try{
                        JSONObject js=  new JSONObject(e.getMessage());
                        return js;}catch (Exception err){
                        return null;
                    }
                }


//

                return json;




    }

    @Override
    protected void onPostExecute(JSONObject list) {

    }

}
