package com.interview.testimport.services;

import com.interview.testimport.services.models.GitHubRepo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
    @GET("users/{user}/starred")
    Observable<List<GitHubRepo>> getStarredRepos(@Path("user") String userName);
}
