package com.example.sop.api;

import com.example.sop.models.Factory;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    /*@GET("factory/{id}")
    Call<Factory> getFactory(@Path("id") int id);*/

    @GET("factories")
    Observable<List<Factory>> getFactories();

}
