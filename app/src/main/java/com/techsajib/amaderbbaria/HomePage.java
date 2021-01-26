package com.techsajib.amaderbbaria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.techsajib.amaderbbaria.Bank.BankMainPage;
import com.techsajib.amaderbbaria.Blood.BloodMainPage;
import com.techsajib.amaderbbaria.Doctors.DoctorsMainPage;
import com.techsajib.amaderbbaria.Education.EducationMainPage;
import com.techsajib.amaderbbaria.FamousPeople.FamousPeopleMainPage;
import com.techsajib.amaderbbaria.FireService.FireServiceMainPage;
import com.techsajib.amaderbbaria.Gallery.GalleryMainPage;
import com.techsajib.amaderbbaria.Hospital.HospitalMainPage;
import com.techsajib.amaderbbaria.Hotel.HotelMainPage;
import com.techsajib.amaderbbaria.Leader.LeaderMainPage;
import com.techsajib.amaderbbaria.Library.LibraryMainPage;
import com.techsajib.amaderbbaria.MP.MPMainPage;
import com.techsajib.amaderbbaria.Newspaper.NewspaperMainPage;
import com.techsajib.amaderbbaria.Office.OfficeMainPage;
import com.techsajib.amaderbbaria.Organization.OrganizationMainPage;
import com.techsajib.amaderbbaria.Police.PoliceMainPage;
import com.techsajib.amaderbbaria.Postal.PostalMainPage;
import com.techsajib.amaderbbaria.Tourist.TouristMainPage;
import com.techsajib.amaderbbaria.Settings.SettingsMainPage;
import com.techsajib.amaderbbaria.Transportation.TransportationMainPage;
import com.techsajib.amaderbbaria.Upozila.UpozilaMainPage;
import com.techsajib.amaderbbaria.Zila.ZilaMainPage;

public class HomePage extends AppCompatActivity {

    //admob ad variable
    private AdView bannerAd;

    //Cardview variable
    CardView zilaInfo, upozilaInfo, mpInfo, leaderInfo, famousPeopleInfo, educationInfo, hospitalInfo, doctorsInfo, policeInfo, fireServiceInfo,
            transportationInfo, touristInfo, hotelInfo, bankInfo, officeInfo, organizationInfo, newspaperInfo, libraryInfo, postalInfo, galleryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //for admob banner ad system
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        bannerAd = findViewById(R.id.bannerAd1);
        AdRequest adRequest = new AdRequest.Builder().build();
        bannerAd.loadAd(adRequest);

        // for Toolbar settings
        Toolbar toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("আমাদের ব্রাহ্মণবাড়িয়া");

        //for push notifications
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notification", "notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }


                    }
                });

        //ID initialization
        zilaInfo = findViewById(R.id.zilaInfoID);
        upozilaInfo = findViewById(R.id.upozilaInfoID);
        mpInfo = findViewById(R.id.mpInfoID);
        leaderInfo = findViewById(R.id.leaderInfoID);
        famousPeopleInfo = findViewById(R.id.famousPeopleInfoID);
        educationInfo = findViewById(R.id.educationInfoID);
        hospitalInfo = findViewById(R.id.hospitalInfoID);
        doctorsInfo = findViewById(R.id.doctorsInfoID);
        policeInfo = findViewById(R.id.policeInfoID);
        fireServiceInfo = findViewById(R.id.fireServiceInfoID);
        transportationInfo = findViewById(R.id.transportationInfoID);
        touristInfo = findViewById(R.id.touristInfoID);
        hotelInfo = findViewById(R.id.hotelInfoID);
        bankInfo = findViewById(R.id.bankInfoID);
        officeInfo = findViewById(R.id.officeInfoID);
        organizationInfo = findViewById(R.id.organizationInfoID);
        newspaperInfo = findViewById(R.id.newspaperInfoID);
        libraryInfo = findViewById(R.id.libraryInfoID);
        postalInfo = findViewById(R.id.postalInfoID);
        galleryInfo = findViewById(R.id.galleryInfoID);

        //CardView OnClickListener
        zilaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ZilaMainPage.class);
                startActivity(intent);
            }
        });

        upozilaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UpozilaMainPage.class);
                startActivity(intent);
            }
        });

        mpInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MPMainPage.class);
                startActivity(intent);
            }
        });

        leaderInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeaderMainPage.class);
                startActivity(intent);
            }
        });

        famousPeopleInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FamousPeopleMainPage.class);
                startActivity(intent);
            }
        });

        educationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EducationMainPage.class);
                startActivity(intent);
            }
        });

        hospitalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HospitalMainPage.class);
                startActivity(intent);
            }
        });

        doctorsInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DoctorsMainPage.class);
                startActivity(intent);
            }
        });

        policeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PoliceMainPage.class);
                startActivity(intent);
            }
        });

        fireServiceInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FireServiceMainPage.class);
                startActivity(intent);
            }
        });

        transportationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TransportationMainPage.class);
                startActivity(intent);
            }
        });

        touristInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TouristMainPage.class);
                startActivity(intent);
            }
        });

        hotelInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HotelMainPage.class);
                startActivity(intent);
            }
        });

        bankInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BankMainPage.class);
                startActivity(intent);
            }
        });

        officeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OfficeMainPage.class);
                startActivity(intent);
            }
        });

        organizationInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OrganizationMainPage.class);
                startActivity(intent);
            }
        });

        newspaperInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewspaperMainPage.class);
                startActivity(intent);
            }
        });

        libraryInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LibraryMainPage.class);
                startActivity(intent);
            }
        });

        postalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostalMainPage.class);
                startActivity(intent);
            }
        });

        galleryInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GalleryMainPage.class);
                startActivity(intent);
            }
        });
    }

    //for menu settings here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.blood_feed:
                Intent intent = new Intent(getApplicationContext(), BloodMainPage.class);
                startActivity(intent);
                return true;

            case R.id.settings:
                Intent intent2 = new Intent(getApplicationContext(), SettingsMainPage.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}