package com.example.ashraynaik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView splashtext1,splashinfo1;
private static int splashtimeout=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashtext1=findViewById(R.id.splashtext);
        splashinfo1=findViewById(R.id.splashinfo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashintent=new Intent(MainActivity.this,home.class);
                startActivity(splashintent);
                finish();
            }
        },splashtimeout);

        Animation splashanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation2);
        splashtext1.startAnimation(splashanimation);

        Animation splashanimation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation1);
        splashinfo1.startAnimation(splashanimation);


    }
}