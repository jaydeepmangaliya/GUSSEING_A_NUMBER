package com.example.gusseinganumber;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation imganimation , textanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.img);
        textView = findViewById(R.id.text);

        imganimation = AnimationUtils.loadAnimation(this , R.anim.img_animation);
        textanimation = AnimationUtils.loadAnimation(this , R.anim.text_animation);
         imageView.setAnimation(imganimation);
         textView.setAnimation(textanimation);


       new CountDownTimer(5000 , 1000){

           @Override
           public void onTick(long l) {

           }

           @Override
           public void onFinish() {
               startActivity(new Intent(SplashActivity.this ,MainActivity.class));
               finish();

           }
       }.start();
    }
}