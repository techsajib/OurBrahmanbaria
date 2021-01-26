package com.techsajib.amaderbbaria.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.techsajib.amaderbbaria.R;

public class AboutDeveloper extends AppCompatActivity {

    ImageView sajibYoutube, sajibFacebook, sajibInstagram, shimantoYoutube, shimantoFacebook, shimantoInstagram, sajuFacebook, sajuBehance, sajuLinkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_developer);

        //ID initialization for sajib
        sajibYoutube = findViewById(R.id.sajibYoutubeID);
        sajibFacebook = findViewById(R.id.sajibFacebookID);
        sajibInstagram = findViewById(R.id.sajibInstagramID);

        //ID initialization for shimanto
        shimantoYoutube = findViewById(R.id.shimantoYoutubeID);
        shimantoFacebook = findViewById(R.id.shimantoFacebookID);
        shimantoInstagram = findViewById(R.id.shimantoInstagramID);

        //ID initialization for sajurana
        sajuFacebook = findViewById(R.id.sajuFacebookID);
        sajuBehance = findViewById(R.id.sajuBehanceID);
        sajuLinkedin = findViewById(R.id.sajuLinkedinID);


        // for settings Toolbar settings here
        Toolbar toolbar = findViewById(R.id.about_developer_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("নির্মাতা সম্পর্কে");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for MD SAZIBUR RAHMAN
        sajibYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String youtubeURL = "https://www.youtube.com/papelbd";
                Intent youtubeIntent=null;

                try {
                    youtubeIntent=new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setPackage("com.google.android.youtube");
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);

                } catch (ActivityNotFoundException e) {
                    youtubeIntent= new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);
                }
            }
        });

        sajibFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/techsajib"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/techsajib")));
                }
            }
        });

        sajibInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/techsajib"));
                startActivity(intent);
            }
        });

        //FOR HM SHIMANTO
        shimantoYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String youtubeURL = "https://www.youtube.com/channel/UCUNl3NMlp0iGWOvzzS2v6SQ";
                Intent youtubeIntent=null;

                try {
                    youtubeIntent=new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setPackage("com.google.android.youtube");
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);

                } catch (ActivityNotFoundException e) {
                    youtubeIntent= new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);
                }
            }
        });

        shimantoFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/hmmotacchim.shimanto"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/hmmotacchim.shimanto")));
                }
            }
        });

        shimantoInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/h.m.shimanto"));
                startActivity(intent);
            }
        });

        //for Saju Rana
        sajuFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/TechSaju"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/TechSaju")));
                }
            }
        });


        sajuBehance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.behance.net/Techsaju"));
                startActivity(intent);
            }
        });

        sajuLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/techsaju"));
                startActivity(intent);
            }
        });

    }
    }
