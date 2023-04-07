package com.example.supercal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Starting extends AppCompatActivity {
    Animation animation;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        new CountDownTimer(3000,3000){

            @Override
            public void onTick(long millisUntilFinished) {

                textView1.setAnimation(animation);
                textView2.setAnimation(animation);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(Starting.this,MainActivity.class));
                finish();
            }
        }.start();



    }
}