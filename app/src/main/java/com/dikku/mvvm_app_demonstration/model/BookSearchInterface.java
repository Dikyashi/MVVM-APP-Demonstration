package com.dikku.mvvm_app_demonstration.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dikyashitamang on 25/02/22
 */
public interface BookSearchInterface {

    @GET("/books")
    Call<VolumeResponse> searchBook(@Query("q") String key,@Query("inauthor") String author);
}
