package com.techsajib.amaderbbaria.Blood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
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

public class BloodMainPage extends AppCompatActivity {

    //Recycler initialization
    RecyclerView recyclerView;
    //Adapter calling
    BloodAdapter bloodAdapter;
    //list initialization
    List<BloodModel> bloodListItems;
    //JSON URL initialization
    String jsonURL = "https://our-brahmanbaria.000webhostapp.com/blood.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_main_page);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.blood_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ব্লাড ক্যাম্প");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for recyclerview option
        recyclerView = findViewById(R.id.bloodRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bloodListItems = new ArrayList<>();

        //load data from this method
        loadBloodData();
    }

    private void loadBloodData() {

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
                    JSONArray jsonArray = jsonObject.getJSONArray("blood");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        //Data Model initialization
                        BloodModel items = new BloodModel(
                                recieveData.getString("url"),
                                recieveData.getString("emergency"),
                                recieveData.getString("details"),
                                recieveData.getString("name"),
                                recieveData.getString("number"),
                                recieveData.getString("bloodgroup"),
                                recieveData.getString("location")

                        );

                        //add every items in list
                        bloodListItems.add(items);
                    }

                    //set adapter
                    bloodAdapter = new BloodAdapter(bloodListItems, getApplicationContext());
                    recyclerView.setAdapter(bloodAdapter);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //In case data doesn't load then toast appeared
                Toast.makeText(BloodMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}