package com.example.androidassigment.activty;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.androidassigment.R;
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