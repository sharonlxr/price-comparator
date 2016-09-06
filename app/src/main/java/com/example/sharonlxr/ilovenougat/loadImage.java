package com.example.sharonlxr.ilovenougat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
public class loadImage extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            String rl = params[0];
            URL url = new URL(rl);
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (Exception e){
            return null;
        }



    }

    @Override
    protected void onPostExecute(Bitmap list) {

    }
}
