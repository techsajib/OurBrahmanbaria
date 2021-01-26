package com.techsajib.amaderbbaria.Tourist;

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

import static com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage.AUTHOR_NAME;
import static com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage.AUTHOR_URL;
import static com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage.IMAGE_URL;
import static com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage.POST_DES;
import static com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage.POST_TITLE;

public class TouristDetails extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ImageView postImage, authorImage;
    TextView author, title, description;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourist_details);

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.touristDetails_Toobar);
        toolbar.setTitle("বিস্তারিত");
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String imageURL = intent.getStringExtra(IMAGE_URL);
        String authorURL = intent.getStringExtra(AUTHOR_URL);
        String authorName = intent.getStringExtra(AUTHOR_NAME);
        String postTitle = intent.getStringExtra(POST_TITLE);
        String postDes = intent.getStringExtra(POST_DES);

        postImage = findViewById(R.id.touristDetailsImageID);
        authorImage = findViewById(R.id.touristDetailsAuthorPictureID);
        author = findViewById(R.id.touristDetailsAuthorNameID);
        title = findViewById(R.id.touristDetailsTitleID);
        description = findViewById(R.id.touristDetailsDescriptionID);

        author.setText("লেখক: " + authorName);
        title.setText(postTitle);
        description.setText(postDes);

        Picasso.get().load(imageURL).into(postImage);
        Picasso.get().load(authorURL).into(authorImage);
    }
}