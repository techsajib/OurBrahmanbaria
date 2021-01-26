package com.techsajib.amaderbbaria.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.techsajib.amaderbbaria.HomePage;
import com.techsajib.amaderbbaria.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN =  3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //for Splash screen Timing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}