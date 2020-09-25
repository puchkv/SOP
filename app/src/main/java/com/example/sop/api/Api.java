package com.example.sop.api;

import com.example.sop.models.Category;
import com.example.sop.models.Department;
import com.example.sop.models.Factory;
import com.example.sop.models.Sector;
import com.example.sop.models.Sop;

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

    @GET("factory/{id}")
    Single<List<Department>> getFactoryDepartments(@Path("id") int factory_id);

    @GET("department/{id}")
    Single<List<Sector>> getDepartmentSectors(@Path("id") int department_id);

    @GET("sector/{id}")
    Single<List<Category>> getSectorCategories(@Path("id") int sector_id);

    @GET("/category/{id}")
    Single<List<Sop>> getCategorySops(@Path("id") int category_id);

    @GET("/sop/{id}")
    Single<Sop> getSop(@Path("id") int sop_id);
}
