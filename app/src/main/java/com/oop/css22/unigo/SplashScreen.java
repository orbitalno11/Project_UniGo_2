package com.oop.css22.unigo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private long deley_time;
    private long time = 750L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }


    public void onResume(){
        super.onResume();
        deley_time = time;
        handler.postDelayed(runnable,deley_time);
        time  =System.currentTimeMillis();
    }

    public void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);
        time = deley_time - (System.currentTimeMillis()-time);
    }
}
