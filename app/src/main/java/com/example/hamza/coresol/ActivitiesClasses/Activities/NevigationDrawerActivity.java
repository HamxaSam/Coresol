package com.example.hamza.coresol.ActivitiesClasses.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hamza.coresol.ActivitiesClasses.Fragments.GenreFragment;
import com.example.hamza.coresol.ActivitiesClasses.Fragments.HomeFragment;
import com.example.hamza.coresol.R;

public class NevigationDrawerActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    FragmentManager fragmentManager;

    /*.......................when backbutton click app close and nevi.......................................*/
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*.......................design of app will create here..........................................................*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Coresol App");

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        navigationView.setNavigationItemSelectedListener(this);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            Fragment fragment = new HomeFragment();
            navigationView.getMenu().getItem(0).setChecked(true);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.flContent, fragment)
                    .commit();
        }
    }
   /*,.............................on Nevigational item click.............................................*/
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;

        switch (id) {
            case R.id.Home:
                fragment = new HomeFragment();
                break;
            case R.id.Genre:
                //fragment = new HomeFragment();
                break;
            case R.id.Countries:
                //   fragment = new colorPicker_activity();
                break;

            case R.id.Movies:
                //  fragment = new facebook_activity();
                break;
            case R.id.List:
                //  fragment = new facebook_activity();
                break;
            case R.id.Requested:
                //  fragment = new facebook_activity();
                break;
            default:
//                fragment = new GenreFragment();
                break;
        }

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();
        navigationView.setCheckedItem(id);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
/*.......................Option Menu code.............................................................*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.About:
                Intent intent = new Intent(NevigationDrawerActivity.this,SearchActivity.class);
                startActivity(intent);

                Toast.makeText(getApplication(), "About ", Toast.LENGTH_SHORT).show();
            case R.id.search:
                intent = new Intent(NevigationDrawerActivity.this,VideoPlayerActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    }
