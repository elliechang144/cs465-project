package com.example.illinialertapp;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    SettingsFragment settingsFragment = new SettingsFragment();
    HomeFragment homeFragment = new HomeFragment();
    MapFragment mapFragment = new MapFragment();
    DataFragment dataFragment = new DataFragment();
    CallFragment callFragment = new CallFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_settings) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, settingsFragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, homeFragment)
                    .commit();
            return true;
        }
        else if (itemId == R.id.map) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, mapFragment)
                    .commit();
            return true;
        }
        else if (itemId == R.id.data) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, dataFragment)
                    .commit();
            return true;
        }
        else if (itemId == R.id.call) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, callFragment)
                    .commit();
            return true;
        }
        return false;
    }
}