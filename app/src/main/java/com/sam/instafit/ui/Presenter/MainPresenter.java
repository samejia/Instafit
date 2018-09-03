package com.sam.instafit.ui.Presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.sam.instafit.models.Result;
import com.sam.instafit.network.NetworkClient;
import com.sam.instafit.network.NetworkInterface;
import com.sam.instafit.ui.Views.MainPresenterInterface;
import com.sam.instafit.ui.Views.MainViewInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {
    MainViewInterface mvi;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getMovies() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<Result> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Result> getObserver(){
        return new DisposableObserver<Result>() {

            @Override
            public void onNext(@NonNull Result movieResponse) {
                Log.d(TAG,"OnNext"+movieResponse.getMessage());
                mvi.displayMovies(movieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}