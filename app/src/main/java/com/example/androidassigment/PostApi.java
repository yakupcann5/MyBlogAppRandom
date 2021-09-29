package com.example.androidassigment;

import com.example.androidassigment.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    //https://jsonplaceholder.typicode.com/todos
    @GET("todos")
    Call<List<Post>> GetPost ();

}
