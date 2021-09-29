package com.example.androidassigment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidassigment.PostApi;
import com.example.androidassigment.R;
import com.example.androidassigment.Utils;
import com.example.androidassigment.adapters.ToDoFragmentAdapter;
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

public class ToDoFragment extends Fragment {
    RecyclerView recyclerView;
    Retrofit retrofit;
    public ToDoFragment(){
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        recyclerView = recyclerView.findViewById(getId());
    }
    public void initPost(ArrayList<Post> post){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ToDoFragmentAdapter toDoFragmentAdapter = new ToDoFragmentAdapter(post,getContext());
        recyclerView.setAdapter(toDoFragmentAdapter);
    }
    public void GetPost() {
        PostApi postApi = retrofit.create(PostApi.class);
        Call<List<Post>> call = postApi.GetPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                ArrayList<Post> post = new ArrayList<>();
                post = (ArrayList<Post>)response.body();
                initPost(post);
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }
}





