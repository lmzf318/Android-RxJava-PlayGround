package com.interview.testimport;

import android.os.Bundle;
import android.util.Log;

import com.interview.testimport.services.models.GitHubRepo;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.observers.DisposableObserver;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private MainViewModel mainViewModel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO add observed data to UI
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getRepos(new DisposableObserver<List<GitHubRepo>>() {
            @Override
            public void onNext(@NonNull List<GitHubRepo> gitHubRepos) {
                Log.i(TAG,"onNext: " + Arrays.toString(gitHubRepos.toArray()));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG,"onError: " + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG,"onComplete");
            }
        });
    }
}
