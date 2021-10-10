package com.satyam.mycalculater;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;


public class splash_screen extends AppCompatActivity {
    ImageView iv;
    long Delay = 5000;
    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 2000;
    LinearLayout ll_1, ll_2;

    int progresscount = 0;
    ImageView img_icon;
    String general = "general-setting";
    ImageView staic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();


        Timer RunSplash = new Timer();

        // Task to do when the timer ends

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    startActivity(new Intent(splash_screen.this, MainActivity.class));

            }
        }, SPLASH_TIME_OUT);
    }
}