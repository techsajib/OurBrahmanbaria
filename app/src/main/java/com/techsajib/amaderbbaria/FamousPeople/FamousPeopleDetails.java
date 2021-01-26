package com.techsajib.amaderbbaria.FamousPeople;

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

public class FamousPeopleDetails extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ImageView postImage, authorImage;
    TextView author, title, description;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.famous_people_details);

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.famousPeopleDetails_Toobar);
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

        postImage = findViewById(R.id.famousPeopleDetailsImageID);
        authorImage = findViewById(R.id.famousPeopleDetailsAuthorPictureID);
        author = findViewById(R.id.famousPeopleDetailsAuthorNameID);
        title = findViewById(R.id.famousPeopleDetailsTitleID);
        description = findViewById(R.id.famousPeopleDetailsDescriptionID);

        author.setText("লেখক: " + authorName);
        title.setText(postTitle);
        description.setText(postDes);

        Picasso.get().load(imageURL).into(postImage);
        Picasso.get().load(authorURL).into(authorImage);

    }
}