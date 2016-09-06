package com.example.sharonlxr.ilovenougat;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.ExtractEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ExtractEditText  editText;
    private class MyFocusChangeListener implements View.OnFocusChangeListener {

        public void onFocusChange(View v, boolean hasFocus){

            if(v.getId() == R.id.searchInput && !hasFocus) {

                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
        }
    }
    //    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        if(editText.hasFocus()) {
//            imm.showSoftInput(v, 0);
//        } else {
//            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editText = (ExtractEditText)findViewById(R.id.searchInput);
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(editText,
//                0);

//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        setContentView(R.layout.activity_main);
    }
    protected  void clearOnClick(View v){

        final ExtractEditText editText = (ExtractEditText)findViewById(R.id.searchInput);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

            }
        });
    }
    public void submit(View v){
        Button bt = (Button) findViewById(R.id.submit);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,dl.class);
                ExtractEditText editText = (ExtractEditText)findViewById(R.id.searchInput);
                String query = editText.getText().toString();
                intent.putExtra("query",query);
                startActivity(intent);
            }
        });
    }
}
