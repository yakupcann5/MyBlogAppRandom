package com.example.androidassigment.activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidassigment.PostApi;
import com.example.androidassigment.R;
import com.example.androidassigment.adapters.ToDoFragmentAdapter;
import com.example.androidassigment.Utils;
import com.example.androidassigment.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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