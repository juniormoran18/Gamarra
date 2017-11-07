package com.example.junior.gamarra_app.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.junior.gamarra_app.R;

public class SplashActivity extends AppCompatActivity {

    LinearLayout a11,a12;
    Button btncont;
    Animation uptowndown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //btncont = (Button)findViewById(R.id.button);
        a11 = (LinearLayout) findViewById(R.id.a11);
        a12 = (LinearLayout) findViewById(R.id.a12);
        uptowndown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        a11.setAnimation(uptowndown);
        a12.setAnimation(downtoup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
            }
        }, 3000); // 3 segundos
    }
}
