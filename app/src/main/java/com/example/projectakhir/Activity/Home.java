package com.example.projectakhir.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.projectakhir.Fragment.FavoriteFragment;
import com.example.projectakhir.Fragment.HolidaysFragment;
import com.example.projectakhir.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragement;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.home_btmnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_btmnav_date:
                selectedFragement = new HolidaysFragment();
                loadFragment(selectedFragement);
                break;

            case R.id.menu_btmnav_favorite:
                selectedFragement = new FavoriteFragment();
                loadFragment(selectedFragement);
                break;


        }
        return false;
    }

    private boolean loadFragment(Fragment selectedFragement) {
        if(selectedFragement != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_container, selectedFragement)
                    .commit();
            return true;
        }
        return false;
    }
}
