package com.example.sharonlxr.ilovenougat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

public class errorTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String error= getIntent().getStringExtra("error");
        pmQuery pm = new pmQuery();
        TextView tv = (TextView)findViewById(R.id.errorInfo);tv.setText(error);
//        try{
//        JSONObject jo = pm.execute(new String[]{"8354764"}).get();
//        if(jo!=null){
//        tv.setText(jo.toString());}else{tv.setText("fuck");}}catch (Exception e){
//            tv.setText(e.toString());
//        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
