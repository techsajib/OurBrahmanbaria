package com.techsajib.amaderbbaria.MP;

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

public class MPMainPage extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    RecyclerView recyclerView;
    MPAdapter mpAdapter;
    List<MPModel> mpListItems;
    String jsonURL = "https://our-brahmanbaria.000webhostapp.com/mp.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp_main_page);

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
        Toolbar toolbar = findViewById(R.id.mp_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("সাংসদ");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        recyclerView = findViewById(R.id.mpRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mpListItems = new ArrayList<>();

        loadMPData();

    }

    private void loadMPData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, jsonURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                if (response != null){
                    try {
                        response=new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("mpdata");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        MPModel items = new MPModel(
                                recieveData.getString("area"),
                                recieveData.getString("image"),
                                recieveData.getString("name"),
                                recieveData.getString("title"),
                                recieveData.getString("party"),
                                recieveData.getString("upozila"),
                                recieveData.getString("des")
                        );

                        mpListItems.add(items);
                    }

                    mpAdapter = new MPAdapter(mpListItems, getApplicationContext());
                    recyclerView.setAdapter(mpAdapter);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MPMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

}