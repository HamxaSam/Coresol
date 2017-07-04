package com.example.hamza.coresol.ActivitiesClasses.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hamza.coresol.R;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {
    Intent intent;
    Handler handler;
    ImageView imageView_splash;
    TextView textView_splash;


    /*............................Splash activity design creation ............................................................*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar();
        imageView_splash = (ImageView)findViewById(R.id.imageView_splash);
        int DELAY = 6000;
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.push_up_out);
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.push_up_in);


        /*..................................hy Baby animation starts from here......................................................*/

        imageView_splash.startAnimation(animationFadeIn);
        imageView_splash.animate()
                .setStartDelay(100)
                .setDuration(5000);
/*........................................intent passinng ..........................................................*/

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(SplashActivity.this,NevigationDrawerActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);


    }
}
