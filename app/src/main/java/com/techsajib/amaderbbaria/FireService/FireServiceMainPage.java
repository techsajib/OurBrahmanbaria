package com.techsajib.amaderbbaria.FireService;

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

public class FireServiceMainPage extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    //Recycler initialization
    RecyclerView recyclerView;
    //Adapter calling
    FireServiceAdapter fireServiceAdapter;
    //list initialization
    List<FireServiceModel> fireServiceListItems;
    //JSON URL initialization
    String jsonURL = "https://our-brahmanbaria.000webhostapp.com/fireservice.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_service_main_page);

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
        Toolbar toolbar = findViewById(R.id.fireservice_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ফায়ার সার্ভিস");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for recyclerview option
        recyclerView = findViewById(R.id.fireServiceRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fireServiceListItems = new ArrayList<>();

        //load data from this method
        loadFireServiceData();
    }

    private void loadFireServiceData() {

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
                    JSONArray jsonArray = jsonObject.getJSONArray("fireservice");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        //Data Model initialization
                        FireServiceModel items = new FireServiceModel(
                                recieveData.getString("name"),
                                recieveData.getString("number"),
                                recieveData.getString("time"),
                                recieveData.getString("web"),
                                recieveData.getString("address"),
                                recieveData.getString("service")

                        );

                        //add every items in list
                        fireServiceListItems.add(items);
                    }

                    //set adapter
                    fireServiceAdapter = new FireServiceAdapter(fireServiceListItems, getApplicationContext());
                    recyclerView.setAdapter(fireServiceAdapter);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //In case data doesn't load then toast appeared
                Toast.makeText(FireServiceMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}