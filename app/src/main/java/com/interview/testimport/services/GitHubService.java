package com.interview.testimport.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubService {
    private static Retrofit retrofit = new Retrofit.Builder()
            .client(new OkHttpClient.Builder().build())
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S>S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
