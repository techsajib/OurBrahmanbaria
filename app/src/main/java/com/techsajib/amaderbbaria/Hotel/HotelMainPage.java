package com.techsajib.amaderbbaria.Hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.techsajib.amaderbbaria.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HotelMainPage extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    //Recycler initialization
    RecyclerView recyclerView;
    //Adapter calling
    HotelAdapter hotelAdapter;
    //list initialization
    List<HotelModel> hotelListItems;
    //JSON URL initialization
    String jsonURL = "https://our-brahmanbaria.000webhostapp.com/hotel.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_main_page);

        //for Interstitial ad system
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "Ad wasn't loaded yet.");
                        }
                    }
                });
            }
        }, 5, 5, TimeUnit.SECONDS);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.hotel_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("হোটেল");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for recyclerview option
        recyclerView = findViewById(R.id.hotelRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hotelListItems = new ArrayList<>();

        //load data from this method
        loadHotelData();
    }

    private void loadHotelData() {

        //for progressDialog showing
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, jsonURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //for progressDialog dismiss
                progressDialog.dismiss();

                //for character set
                if (response != null){
                    try {
                        response=new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("hotel");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        //Data Model initialization
                        HotelModel items = new HotelModel(
                                recieveData.getString("url"),
                                recieveData.getString("name"),
                                recieveData.getString("type"),
                                recieveData.getString("director"),
                                recieveData.getString("number"),
                                recieveData.getString("address"),
                                recieveData.getString("service")

                        );

                        //add every items in list
                        hotelListItems.add(items);
                    }

                    //set adapter
                    hotelAdapter = new HotelAdapter(hotelListItems, getApplicationContext());
                    recyclerView.setAdapter(hotelAdapter);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //In case data doesn't load then toast appeared
                Toast.makeText(HotelMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}