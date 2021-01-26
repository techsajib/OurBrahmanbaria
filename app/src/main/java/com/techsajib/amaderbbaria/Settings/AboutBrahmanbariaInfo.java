package com.techsajib.amaderbbaria.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.techsajib.amaderbbaria.R;

public class AboutBrahmanbariaInfo extends AppCompatActivity {

    Button inbox, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_brahmanbaria_info);

        // for settings Toolbar settings here
        Toolbar toolbar = findViewById(R.id.about_bb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("তথ্য দিন");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for button ID initialiazation
        inbox = findViewById(R.id.bbInboxID);
        email = findViewById(R.id.bbEmailID);

        //Inbox onClickListener
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/100007831204614"));
                    startActivity(intent);

                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.messenger.com/t/techsajib")));
                }
            }
        });

        //Email onClickListener
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String [] {"sazib.online@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "ব্রাহ্মণবাড়িয়ার তথ্য দিন");
                    String details = getString(R.string.bbinformation);
                    intent.putExtra(Intent.EXTRA_TEXT, details);
                    intent.setType("massage/efc822");
                    startActivity(Intent.createChooser(intent, "শেয়ার করুন"));

                }catch (ActivityNotFoundException anfe){
                    Toast.makeText(AboutBrahmanbariaInfo.this, "দুঃখিত, আপনার কোনো ইমেইল ইন্সটল নেই!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}