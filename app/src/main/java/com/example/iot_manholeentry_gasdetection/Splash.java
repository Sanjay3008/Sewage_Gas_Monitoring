package com.example.iot_manholeentry_gasdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private Handler handler;
    private ImageView d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        d=findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplahanimaiton);
        d.startAnimation(myanim);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(Splash.this,MainActivity.class);
                startActivity(intent1);
                finish();

            }
        },3000);
    }
}
