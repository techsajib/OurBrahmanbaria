package com.techsajib.amaderbbaria.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.techsajib.amaderbbaria.BuildConfig;
import com.techsajib.amaderbbaria.R;

public class SettingsMainPage extends AppCompatActivity {

    ListView listView;

    int mImage[] = {R.drawable.brahmanbaria, R.drawable.ic_blood_iinfo, R.drawable.ic_bb_map, R.drawable.ic_rating, R.drawable.ic_sharing, R.drawable.ic_appdev};
    String mTitle[] = {"এপ সম্পর্কে", "রক্তের তথ্য দিন", "ব্রাহ্মণবাড়িয়ার তথ্য দিন", "রেটিং করুন", "শেয়ার করুন", "কন্ট্রিবিউটর"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main_page);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("সেটিংস");

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for listview settings
        listView = findViewById(R.id.settingsListView);

        MyAdapter adapter = new MyAdapter(this, mImage, mTitle);
        listView.setAdapter(adapter);

        //listview click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position==0){
                    Intent intent = new Intent(getApplicationContext(), AboutApp.class);
                    startActivity(intent);

                }else if (position==1){
                    Intent intent = new Intent(getApplicationContext(), AboutBloodInfo.class);
                    startActivity(intent);

                }else if (position==2){
                    Intent intent = new Intent(getApplicationContext(), AboutBrahmanbariaInfo.class);
                    startActivity(intent);

                }else if (position==3){
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + getPackageName())));
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    }


                }else if (position==4){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Download Our Brahmanbaria App");

                    String appLink="http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    intent.putExtra(Intent.EXTRA_TEXT, appLink);
                    startActivity(Intent.createChooser(intent, "Share by"));


                }else if (position==5){
                    Intent intent = new Intent(getApplicationContext(), AboutDeveloper.class);
                    startActivity(intent);

                }
            }
        });

    }

    // for listview adapter
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        int sImage[];
        String sTitle[];

        MyAdapter (Context c, int image[], String title[]){
            super(c, R.layout.settings_main_page_row, R.id.settings_listview_Text, title);
            this.context = c;
            this.sImage = image;
            this.sTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.settings_main_page_row, parent, false);

            ImageView imageView = view.findViewById(R.id.settings_listview_Logo);
            TextView titleText = view.findViewById(R.id.settings_listview_Text);

            imageView.setImageResource(sImage[position]);
            titleText.setText(sTitle[position]);

            return view;

        }
    }
}