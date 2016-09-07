package com.example.sharonlxr.ilovenougat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;

public class scanBarcode extends AppCompatActivity {
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_barcode);

        scanQR();
    }
        public void scanQR() {

        try {

            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE","CODE_128");
//            intent.putExtra("SCAN_FORMATS", BarcodeFormat.CODE_128);
            startActivityForResult(intent, 0);

        } catch (ActivityNotFoundException anfe) {


        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == 0) {

            if (resultCode!= RESULT_CANCELED) {

                //get the extras that are returned from the intent

                String contents = intent.getStringExtra("SCAN_RESULT");
//                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Intent newIt = new Intent(scanBarcode.this,dl.class);
                String id = contents.substring(10);
                newIt.putExtra("query",id);
                startActivity(newIt);
//
//                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
//
//                toast.show();

            }else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
                Intent in = new Intent(scanBarcode.this,MainActivity.class);
                startActivity(in);

            }

        }
        }


}
