package com.techsajib.amaderbbaria.Zila;


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

public class ZilaMainPage extends AppCompatActivity implements ZilaAdapter.OnItemClickListener {

    public static final String IMAGE_URL = "imageURL";
    public static final String POST_TITLE = "postTitle";
    public static final String POST_DETAILS = "postDes";

    RecyclerView recyclerView;
    ZilaAdapter zilaAdapter;
    List<ZilaModel> zilaListItems;
    String jsonFamousURL = "https://our-brahmanbaria.000webhostapp.com/zila.json";
    //for progress dialog
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zila_main_page);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.zila_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("জেলা সংক্রান্ত");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.zilaRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        zilaListItems = new ArrayList<>();

        loadZilaData();

    }

    private void loadZilaData() {

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
                    JSONArray jsonArray = jsonObject.getJSONArray("zila");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        ZilaModel items = new ZilaModel(
                                recieveData.getString("url"),
                                recieveData.getString("title"),
                                recieveData.getString("details")

                        );

                        zilaListItems.add(items);

                    }

                    zilaAdapter = new ZilaAdapter(zilaListItems, getApplicationContext());
                    recyclerView.setAdapter(zilaAdapter);
                    zilaAdapter.setOnItemClickListener(ZilaMainPage.this);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ZilaMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onItemClick(int position) {

        Intent detailIntent = new Intent(this, ZilaDetails.class);
        ZilaModel clickedModelItem = zilaListItems.get(position);

        detailIntent.putExtra(IMAGE_URL, clickedModelItem.getUrl());
        detailIntent.putExtra(POST_TITLE, clickedModelItem.getTitle());
        detailIntent.putExtra(POST_DETAILS, clickedModelItem.getDetails());

        startActivity(detailIntent);
    }
}