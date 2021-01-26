package com.techsajib.amaderbbaria.Organization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;
import com.techsajib.amaderbbaria.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.techsajib.amaderbbaria.Organization.OrganizationMainPage.IMAGE_URL;
import static com.techsajib.amaderbbaria.Organization.OrganizationMainPage.POST_DETAILS;
import static com.techsajib.amaderbbaria.Organization.OrganizationMainPage.POST_TITLE;

public class OrganizationDetails extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ImageView postImage;
    TextView title, description;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization_details);

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

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.dismiss();

        // for Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.organizationDetails_Toobar);
        toolbar.setTitle("বিস্তারিত");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        String imageURL = intent.getStringExtra(IMAGE_URL);
        String postTitle = intent.getStringExtra(POST_TITLE);
        String postDes = intent.getStringExtra(POST_DETAILS);

        postImage = findViewById(R.id.organizationDetailsImageID);
        title = findViewById(R.id.organizationDetailsTitleID);
        description = findViewById(R.id.organizationDetailsDescriptionID);

        title.setText(postTitle);
        description.setText(postDes);

        Picasso.get().load(imageURL).into(postImage);
    }
}