package com.example.lab2mt;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com"; // Замените на ваш URL

    private static Retrofit retrofit;

    public RetrofitClient(String base_url) {
        this.BASE_URL = base_url;
    }

    public static Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
