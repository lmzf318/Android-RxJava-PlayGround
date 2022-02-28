package com.interview.testimport.services;

import com.interview.testimport.services.models.GitHubRepo;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Observable;

public class GitHubRepository {
    private static GitHubRepository mInstance = null;
    private static GitHubApi mGitHubApi = null;

    public GitHubRepository(){
        mGitHubApi = GitHubService.createService(GitHubApi.class);
    }

    public synchronized static GitHubRepository getInstance(){
        if(mInstance == null){
            mInstance = new GitHubRepository();
        }
        return mInstance;
    }

    public Observable<List<GitHubRepo>> getStarredRepos(@NonNull String userName){
        return mGitHubApi.getStarredRepos(userName);
    }
}
