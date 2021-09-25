package com.example.androidassigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSayfaIkiyeGit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSayfaIkiyeGit = findViewById(R.id.button_button_sayfa_bir);

        btnSayfaIkiyeGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sayfaIki = new Intent(MainActivity.this, SayfaIkiActivity.class);
                startActivity(sayfaIki);
            }
        });
    }
}