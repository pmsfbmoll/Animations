package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuizSplashActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences lastTime = getSharedPreferences("Carrega", MODE_PRIVATE);
        Date now = new Date();
        SimpleDateFormat format =new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");
        Log.i("patata", "In QuizSplashActivity");
        if (lastTime.contains("dateTime") == true) {
            //We have recorded the last time we used the game
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i("patata", "In QuizSplashActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        dateEditor.putString("dateTime",format.format(now));
        dateEditor.commit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_splash);
        ImageView logo = findViewById(R.id.imageView);
        Animation animation_logo = AnimationUtils.loadAnimation(this,R.anim.logoanim);
        animation_logo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(QuizSplashActivity.this,QuizMenuActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        logo.startAnimation(animation_logo);



    }
}
