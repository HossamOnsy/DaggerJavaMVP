package com.sam.daggerjavamvp.network;

import com.sam.daggerjavamvp.model.Cat;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceInterface {

    @GET("images/search")
    Observable<List<Cat>> getCats(@Query("limit") int limit);

}
