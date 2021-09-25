package com.example.androidassigment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidassigment.fragment.HomeFragment;
import com.example.androidassigment.fragment.ProfilFragment;
import com.example.androidassigment.fragment.ToDoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SayfaIkiActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa_iki);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }
    HomeFragment homeFragment = new HomeFragment();
    ProfilFragment profilFragment = new ProfilFragment();
    ToDoFragment todoFragment = new ToDoFragment();

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;

            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profilFragment).commit();
                return true;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, todoFragment).commit();
                return true;
        }
        return false;
    }
}