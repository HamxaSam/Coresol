package com.example.hamza.coresol.ActivitiesClasses.Activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.hamza.coresol.R;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

/**
 * Created by Hamza on 5/26/2017.
 */

public class IntroActivity extends MaterialIntroActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0.0, to = 1.0) float percentage) {

                    }
                });

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorAccent)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.coresol)
                .title("Organize your time with us")
                .description("Would you try?")
                .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("We provide Latest Movie's Easy Access ");
            }
                }, "Entertaintment with love"));

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorAccent)
                .buttonsColor(R.color.colorPrimaryDark)
                .image(R.drawable.five)
                .title("Want more?")
                .description("Let's Entertain with Coresol")
                .build());

        // addSlide(new CustomSlide());

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorPrimary)
                        .buttonsColor(R.color.colorPrimary)
                        .possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
                        .neededPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
                        .image(R.drawable.one)
                        .title("We provide best PlatForm Ever")
                        .description("CoresolDeveloper@gmail.com")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Try us!");
                    }
                }, "Tools"));

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorAccent)
                .buttonsColor(R.color.colorPrimaryDark)
                .title("That's it")
                .description("Would you join us?")
                .build());

     //   Intent intent = new Intent(IntroActivity.this,SplashActivity.class);
     //       startActivity(intent);
    }

    @Override
    public void onFinish() {
        Intent intent = new Intent(IntroActivity.this,SplashActivity.class);
        startActivity(intent);
        super.onFinish();
    }
}

