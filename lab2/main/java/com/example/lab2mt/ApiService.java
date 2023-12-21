package com.example.lab2mt;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {
    @GET("/posts")
    Call<List<PostModel>> getPosts();
}
