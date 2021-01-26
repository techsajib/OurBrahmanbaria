package com.techsajib.amaderbbaria.Organization;

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

public class OrganizationMainPage extends AppCompatActivity implements OrganizationAdapter.OnItemClickListener{

    public static final String IMAGE_URL = "imageURL";
    public static final String POST_TITLE = "postTitle";
    public static final String POST_DETAILS = "postDes";

    RecyclerView recyclerView;
    OrganizationAdapter organizationAdapter;
    List<OrganizationModel> organizationListItems;
    String jsonFamousURL = "https://our-brahmanbaria.000webhostapp.com/organization.json";
    //for progress dialog
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization_main_page);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.organization_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("সামাজিক সংগঠন");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.organizationRecylerviewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        organizationListItems = new ArrayList<>();

        loadOrganizationData();
    }

    private void loadOrganizationData() {

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
                    JSONArray jsonArray = jsonObject.getJSONArray("organization");

                    for (int i=0; i<jsonArray.length(); i++){

                        JSONObject recieveData = jsonArray.getJSONObject(i);

                        OrganizationModel items = new OrganizationModel(
                                recieveData.getString("url"),
                                recieveData.getString("title"),
                                recieveData.getString("details")

                        );

                        organizationListItems.add(items);

                    }

                    organizationAdapter = new OrganizationAdapter(organizationListItems, getApplicationContext());
                    recyclerView.setAdapter(organizationAdapter);
                    organizationAdapter.setOnItemClickListener(OrganizationMainPage.this);


                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(OrganizationMainPage.this, "দুঃখিত, ইন্টারনেট সংযুক্ত করুন!", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, OrganizationDetails.class);
        OrganizationModel clickedModelItem = organizationListItems.get(position);

        detailIntent.putExtra(IMAGE_URL, clickedModelItem.getUrl());
        detailIntent.putExtra(POST_TITLE, clickedModelItem.getTitle());
        detailIntent.putExtra(POST_DETAILS, clickedModelItem.getDetails());

        startActivity(detailIntent);
    }
}