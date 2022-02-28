package com.interview.testimport;

import com.interview.testimport.services.GitHubRepository;
import com.interview.testimport.services.models.GitHubRepo;

import java.util.List;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private GitHubRepository gitHubRepository = null;
    private Disposable subscription = null;

    public MainViewModel() {
        super();
        gitHubRepository = GitHubRepository.getInstance();
    }

    public void getRepos(DisposableObserver<List<GitHubRepo>> observer){
        subscription = gitHubRepository
                .getStarredRepos("lmzf318")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}
