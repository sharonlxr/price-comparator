package com.example.sharonlxr.ilovenougat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class dl extends AppCompatActivity {
    zappoQuery zq;
    JSONObject jo;
    public String getUrl(String productID){
      try{return jo.getString(productID+"url");}catch (Exception e){return null;}

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ListView lv = (ListView)findViewById(R.id.testList);
//        TextView tt= (TextView)findViewById(R.id.total);
        String ni =getIntent().getStringExtra("query");
        setContentView(R.layout.activity_dl);
        RecyclerView rv= (RecyclerView)findViewById(R.id.rv);
//        rv.setEnabled(false);
//        tt.setEnabled(false);
         zq = new zappoQuery();
        try{



//            JSONObject jo= new JSONObject("{\"originalTerm\":\"nike\",\"currentResultCount\":\"10\",\"totalResultCount\":\"4092\",\"term\":\"nike\",\"results\":[{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/2\\/6\\/3\\/2\\/6\\/1\\/2632610-t-THUMBNAIL.jpg\",\"productId\":\"8302169\",\"originalPrice\":\"$116.00\",\"styleId\":\"2632610\",\"colorId\":\"20451\",\"price\":\"$92.99\",\"percentOff\":\"19%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8302169\\/color\\/20451\",\"productName\":\"Nike Cruiser\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/6\\/4\\/2\\/8\\/3464286-t-THUMBNAIL.jpg\",\"productId\":\"8354764\",\"originalPrice\":\"$139.99\",\"styleId\":\"3464286\",\"colorId\":\"608877\",\"price\":\"$112.99\",\"percentOff\":\"19%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8354764\\/color\\/608877\",\"productName\":\"Nike Lunarwaverly\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/6\\/2\\/0\\/0\\/2\\/3620027-t-THUMBNAIL.jpg\",\"productId\":\"8361229\",\"originalPrice\":\"$40.00\",\"styleId\":\"3620027\",\"colorId\":\"635852\",\"price\":\"$40.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8361229\\/color\\/635852\",\"productName\":\"Nike Textured Foam Roller\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/6\\/2\\/0\\/0\\/2\\/3620026-t-THUMBNAIL.jpg\",\"productId\":\"8361229\",\"originalPrice\":\"$40.00\",\"styleId\":\"3620026\",\"colorId\":\"635851\",\"price\":\"$40.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8361229\\/color\\/635851\",\"productName\":\"Nike Textured Foam Roller\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/6\\/8\\/3411685-t-THUMBNAIL.jpg\",\"productId\":\"8637228\",\"originalPrice\":\"$14.00\",\"styleId\":\"3411685\",\"colorId\":\"20476\",\"price\":\"$14.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637228\\/color\\/20476\",\"productName\":\"Nike Stadium Football Crew\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/7\\/0\\/3411704-t-THUMBNAIL.jpg\",\"productId\":\"8637230\",\"originalPrice\":\"$18.00\",\"styleId\":\"3411704\",\"colorId\":\"31878\",\"price\":\"$18.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637230\\/color\\/31878\",\"productName\":\"Nike Stadium Football OTC\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/7\\/0\\/3411705-t-THUMBNAIL.jpg\",\"productId\":\"8637230\",\"originalPrice\":\"$18.00\",\"styleId\":\"3411705\",\"colorId\":\"20476\",\"price\":\"$18.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637230\\/color\\/20476\",\"productName\":\"Nike Stadium Football OTC\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/7\\/0\\/3411707-t-THUMBNAIL.jpg\",\"productId\":\"8637230\",\"originalPrice\":\"$18.00\",\"styleId\":\"3411707\",\"colorId\":\"335849\",\"price\":\"$18.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637230\\/color\\/335849\",\"productName\":\"Nike Stadium Football OTC\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/7\\/0\\/3411708-t-THUMBNAIL.jpg\",\"productId\":\"8637230\",\"originalPrice\":\"$18.00\",\"styleId\":\"3411708\",\"colorId\":\"352594\",\"price\":\"$18.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637230\\/color\\/352594\",\"productName\":\"Nike Stadium Football OTC\"},{\"brandName\":\"Nike\",\"thumbnailImageUrl\":\"http:\\/\\/www.zappos.com\\/images\\/z\\/3\\/4\\/1\\/1\\/7\\/0\\/3411709-t-THUMBNAIL.jpg\",\"productId\":\"8637230\",\"originalPrice\":\"$18.00\",\"styleId\":\"3411709\",\"colorId\":\"80413\",\"price\":\"$18.00\",\"percentOff\":\"0%\",\"productUrl\":\"http:\\/\\/www.zappos.com\\/product\\/8637230\\/color\\/80413\",\"productName\":\"Nike Stadium Football OTC\"}],\"statusCode\":\"200\"}");
            jo= zq.execute(new String[]{"nike"}).get();
//            TextView tv =(TextView) findViewById(R.id.errorInfoTV);

//            tv.setText(jo.toString());}

            JSONArray results = jo.getJSONArray("results");
            String ct = jo.getString("currentResultCount");
            int n =0;
            ArrayList<ItemData> re = new ArrayList<ItemData>();
            while(!results.isNull(n)){
                JSONObject ob = results.getJSONObject(n);
                String name = ob.getString("productName");
                String pr = ob.getString("price");
                String pid =ob.getString("productId");
                String discount = ob.getString("percentOff");
                String image = pid+"img";
                String url = ob.getString("productUrl");
                Bitmap bt = (Bitmap)jo.get(image);
                ItemData ida = new ItemData(pid,name,pr,discount,url,bt);
                re.add(ida);
                n+=1;
            }

        RecyclerViewExampleAdapter ad= new RecyclerViewExampleAdapter(re);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(ad);

        }catch(Exception e){
//            TextView tv =(TextView) findViewById(R.id.errorInfoTV);
//            tv.setText(e.toString()+e.getStackTrace()+ni);
//            Intent intent = new Intent(dl.this,errorTest.class);
//            intent.putExtra("error",e.getMessage());
//            startActivity(intent);
        }
    }
    public void alertPrice(Context context,final String url){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("this item appears to be cheaper in 6 pm")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("SEE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        try{

                            Uri uriUrl = Uri.parse(url);
                            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(launchBrowser);
                        }catch (Exception e){
                            dialog.dismiss();
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
    public void onlyZappos(Context context,final String url){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("this item only appears in zappos")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("SEE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        try{
                            if(url!=null){
                            Uri uriUrl = Uri.parse(url);
                            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(launchBrowser);}else{
                                dialog.dismiss();
                            }
                        }catch (Exception e){
                            dialog.dismiss();
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public class ItemData {
        public String name;
        public String title;
        public String price;
        public String disc;
        public Bitmap imageUrl;
        public String url;
        public ItemData(String title,String nm,String pr , String dis,String rl,Bitmap image){
            this.name=nm;
            this.title = title;
            this.disc = dis;
            this.price =pr;
            this.url=rl;
            this.imageUrl =image;
            try{
            jo.put(title+"url",rl);}catch (Exception e){

            }
//            this
//            try{
//                JSONObject json = zq.execute(new String[][]{new String[]{"3",image}}).get();
//                this.imageUrl= (Bitmap) json.get("image");
//            }catch (Exception e){
//                Intent intent =new Intent(dl.this,errorTest.class);
//                intent.putExtra("error",e.toString());
//                startActivity(intent);
//            }

        }
        public String getpr(){return price;}
        public String getdc(){return disc;}
        public String getTitle() {
            return title;
        }
        public String getName(){return name;}
        public Bitmap getImageUrl() {
            return imageUrl;
        }
    }

    public class RecyclerViewExampleAdapter extends RecyclerView.Adapter<RecyclerViewExampleAdapter.CViewHolder> {
        private ArrayList<ItemData> itemsData;

        public RecyclerViewExampleAdapter(ArrayList<ItemData> it) {
            this.itemsData = it;
        }

        @Override
        public RecyclerViewExampleAdapter.CViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout, null);

            CViewHolder viewHolder = new CViewHolder(itemLayoutView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CViewHolder viewHolder, int position) {
            try{
            viewHolder.txtViewTitle.setText(itemsData.get(position).getTitle());
            viewHolder.pr.setText(itemsData.get(position).getpr());
            viewHolder.dc.setText("Discount:"+itemsData.get(position).getdc());
            viewHolder.nameTV.setText(itemsData.get(position).getName());
            if(itemsData.get(position).getImageUrl()!=null){
            viewHolder.imgViewIcon.setImageBitmap(itemsData.get(position).getImageUrl());
            }
            }catch (Exception e){
                Intent inten = new Intent(dl.this,errorTest.class);
                inten.putExtra("error",e.toString()+e.getStackTrace());
                startActivity(inten);

            }
//            viewHolder.imgViewIcon.setImageResource(itemsData[position].getImageUrl());
        }

        public  class CViewHolder extends RecyclerView.ViewHolder {

            public TextView txtViewTitle;
            public TextView pr;
            public TextView dc;
            public TextView nameTV;
            public ImageView imgViewIcon;

            public CViewHolder(View itemLayoutView) {
                super(itemLayoutView);
                nameTV=(TextView)itemLayoutView.findViewById(R.id.item_name);
                txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
                pr = (TextView)itemLayoutView.findViewById(R.id.price);
                dc = (TextView)itemLayoutView.findViewById(R.id.discount);
                txtViewTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String productId = (String)txtViewTitle.getText();
                        String price = (String)pr.getText();
                        String newpr = price.substring(1);

                        Float priceNum = Float.parseFloat(newpr);
                        String url = getUrl(productId);
                        ComparePrice(productId,priceNum,url);
                    }
                });
                txtViewTitle.setOnLongClickListener(new View.OnLongClickListener(){
                    @Override
                    public  boolean onLongClick(View v){
                        String productId = (String)txtViewTitle.getText();
                        showBarcode(productId);
                        return true;

                    }
                });
                nameTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String productId = (String)txtViewTitle.getText();
                        String price = (String)pr.getText();
                        String newpr = price.substring(1);

                        Float priceNum = Float.parseFloat(newpr);
                        String url = getUrl(productId);
                        ComparePrice(productId,priceNum,url);
                    }
                });

                imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            }

        }


        @Override
        public int getItemCount() {
            return itemsData.size();
        }
    }
    public void ComparePrice(String id, Float price,String url){
        JSONObject json;
        try {
//            JSONObject json = zq.execute(new String[][]{new String[]{"2",id}}).get();
//            String tp = "{\"originalTerm\":\"8354764\",\"currentResultCount\":\"4\",\"totalResultCount\":\"4\",\"term\":\"8354764\",\"results\":[{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http:\\/\\/www.6pm.com\\/images\\/z\\/2\\/7\\/6\\/5\\/1\\/3\\/2765134-t-THUMBNAIL.jpg\",\"productId\":\"8354764\",\"originalPrice\":\"$139.99\",\"styleId\":\"2765134\",\"colorId\":\"544372\",\"price\":\"$70.00\",\"percentOff\":\"49%\",\"productUrl\":\"http:\\/\\/www.6pm.com\\/product\\/8354764\\/color\\/544372\",\"productName\":\"Nike Lunarwaverly\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http:\\/\\/www.6pm.com\\/images\\/z\\/2\\/7\\/6\\/5\\/1\\/3\\/2765135-t-THUMBNAIL.jpg\",\"productId\":\"8354764\",\"originalPrice\":\"$139.99\",\"styleId\":\"2765135\",\"colorId\":\"498926\",\"price\":\"$30.99\",\"percentOff\":\"35%\",\"productUrl\":\"http:\\/\\/www.6pm.com\\/product\\/8354764\\/color\\/498926\",\"productName\":\"Nike Lunarwaverly\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http:\\/\\/www.6pm.com\\/images\\/z\\/3\\/0\\/6\\/4\\/5\\/7\\/3064577-t-THUMBNAIL.jpg\",\"productId\":\"8354764\",\"originalPrice\":\"$139.99\",\"styleId\":\"3064577\",\"colorId\":\"542666\",\"price\":\"$70.00\",\"percentOff\":\"49%\",\"productUrl\":\"http:\\/\\/www.6pm.com\\/product\\/8354764\\/color\\/542666\",\"productName\":\"Nike Lunarwaverly\"},{\"brandName\":\"Nike Golf\",\"thumbnailImageUrl\":\"http:\\/\\/www.6pm.com\\/images\\/z\\/3\\/0\\/6\\/4\\/5\\/7\\/3064576-t-THUMBNAIL.jpg\",\"productId\":\"8354764\",\"originalPrice\":\"$139.99\",\"styleId\":\"3064576\",\"colorId\":\"542667\",\"price\":\"$77.99\",\"percentOff\":\"44%\",\"productUrl\":\"http:\\/\\/www.6pm.com\\/product\\/8354764\\/color\\/542667\",\"productName\":\"Nike Lunarwaverly\"}],\"statusCode\":\"200\"}";
            pmQuery pm =new pmQuery();

           json = pm.execute(new String[]{id}).get();

            Intent in = new Intent(dl.this,errorTest.class);
//            in.putExtra("error","get an error"+jsonstring);
//            startActivity(in);
            if(json!=null){
            String count = json.getString("totalResultCount");

            int ct = new Integer(count);

            if(count!=null&&ct>0){
                int i =0;
                JSONArray results = json.getJSONArray("results");
                JSONObject lowestpriceItem=results.getJSONObject(0);
                Float target = Float.parseFloat(lowestpriceItem.getString("price").substring(1));
                while(!results.isNull(i)){
                    Float temp = Float.parseFloat(results.getJSONObject(i).getString("price").substring(1));
                    if(temp<target){
                        lowestpriceItem=results.getJSONObject(i);
                        target = temp;
                    }
                i+=1;
                }
                if(target<price){
                    alertPrice(getApplicationContext(),lowestpriceItem.getString("productUrl"));
                }else{
                    onlyZappos(getApplicationContext(),getUrl(id));
                }

            }else{
               onlyZappos(getApplicationContext(),getUrl(id));
            }
            }else{
                onlyZappos(getApplicationContext(),getUrl(id));
            }
        }catch (Exception e){
            Intent in = new Intent(dl.this,errorTest.class);
            in.putExtra("error","get an error"+e.toString());
            startActivity(in);
        }
    }
    public void showBarcode(String productID) {
        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        BarcodeEncoder be = new BarcodeEncoder();
        try{
        Bitmap image = be.encodeAsBitmap(productID, BarcodeFormat.CODE_128, 600, 300);
            imageView.setImageBitmap(image);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();}catch (Exception e){
            builder.dismiss();
        }
    }
//    public Bitmap Ean13_Encode(String qrData,  int qrCodeDimention) {
//        Bitmap bitmap= Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
//        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(qrData, null,
//                Contents.Type.TEXT, BarcodeFormat.EAN_13.toString(), qrCodeDimention);
//        try {
//            bitmap = qrCodeEncoder.encodeAsBitmap();
//        } catch (WriterException e) {
//            e.printStackTrace();
//        };
//        return bitmap;
//    };

}
