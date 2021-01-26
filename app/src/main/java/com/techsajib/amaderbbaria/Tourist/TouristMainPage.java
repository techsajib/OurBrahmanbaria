package com.techsajib.amaderbbaria.Tourist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.techsajib.amaderbbaria.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TouristMainPage extends AppCompatActivity implements TouristAdapter.OnItemClickListener{

    public static final String IMAGE_URL = "imageURL";
    public static final String AUTHOR_URL = "authorURL";
    public static final String AUTHOR_NAME = "authorName";
    public static final String POST_TITLE = "postTitle";
    public static final String POST_DES = "postDes";

    RecyclerView recyclerView;
    TouristAdapter touristAdapter;
    List<TouristModel> touristListItems;
    String jsonFamousURL = "https://our-brahmanbaria.000webhostapp.com/tourist.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_main_page);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.tourist_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("পর্যটন");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.touristRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        touristListItems = new ArrayList<>();

        loadTouristData();
    }

    private void loadTouristData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, jsonFamousURL, new Response.Listener<String>() {
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
                    JSONArray jsonArray = jsonObject.getJSONArray("tourist");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        TouristModel items = new TouristModel(
                                recieveData.getString("url"),
                                recieveData.getString("authoricon"),
                                recieveData.getString("authorname"),
                                recieveData.getString("title"),
                                recieveData.getString("description")

                        );

                        touristListItems.add(items);

                    }

                    touristAdapter = new TouristAdapter(touristListItems, getApplicationContext());
                    recyclerView.setAdapter(touristAdapter);
                    touristAdapter.setOnItemClickListener(TouristMainPage.this);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TouristMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, TouristDetails.class);
        TouristModel clickedModelItem = touristListItems.get(position);

        detailIntent.putExtra(IMAGE_URL, clickedModelItem.getUrl());
        detailIntent.putExtra(AUTHOR_URL, clickedModelItem.getAuthoricon());
        detailIntent.putExtra(AUTHOR_NAME, clickedModelItem.getAuthorname());
        detailIntent.putExtra(POST_TITLE, clickedModelItem.getTitle());
        detailIntent.putExtra(POST_DES, clickedModelItem.getDescription());

        startActivity(detailIntent);
    }
}