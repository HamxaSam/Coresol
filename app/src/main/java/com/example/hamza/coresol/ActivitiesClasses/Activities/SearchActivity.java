package com.example.hamza.coresol.ActivitiesClasses.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hamza.coresol.ActivitiesClasses.Fragments.HomeFragment;
import com.example.hamza.coresol.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SearchActivity.this,NevigationDrawerActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



    }
}
