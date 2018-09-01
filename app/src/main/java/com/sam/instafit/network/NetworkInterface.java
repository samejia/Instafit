package com.sam.instafit.network;

import com.sam.instafit.models.Datum;
import com.sam.instafit.models.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface NetworkInterface {

    @GET("api/v3.1/user/697257/a6kt_yP5y8opx9sz_9Pe/catalog_of/coaches")
    Observable<Result> getMovies();

}
