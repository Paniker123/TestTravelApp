package com.woodman.testtravelapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.fragment.ExploreFragment;
import com.woodman.testtravelapp.fragment.HomeFragment;
import com.woodman.testtravelapp.fragment.ToursFragment;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    ToursFragment toursFragment;
    ExploreFragment exploreFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    homeFragment = HomeFragment.newInstance();
                    fragmentTransaction.replace(R.id.fragment_container, homeFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_tours:
                    toursFragment = ToursFragment.newInstance();
                    fragmentTransaction.replace(R.id.fragment_container, toursFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_explore:

                    exploreFragment = ExploreFragment.newInstance();
                    fragmentTransaction.replace(R.id.fragment_container, exploreFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        homeFragment = new HomeFragment();
        toursFragment = new ToursFragment();
        exploreFragment = new ExploreFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        homeFragment = HomeFragment.newInstance();
        fragmentTransaction.replace(R.id.fragment_container, homeFragment);
        fragmentTransaction.commit();
        setTitle(getString(R.string.fragment_title_home));



    }


}
