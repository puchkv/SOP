package com.example.sop.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final ApiService instance = new ApiService();

    private Retrofit retrofit;
    private String token;

    public static ApiService getInstance() { return instance; }

    private ApiService() {

        /*RxJava3CallAdapterFactory rxAdapter =
                RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io());

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient =
                new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .addInterceptor(chain -> {
                            Request request = chain.request().newBuilder()
                                    .addHeader("Accept", "application/json,text/plain,*//*")
                                    .addHeader("Content-Type", "application/json; odata.metadata=mini")
                                    .addHeader("Auth", token)
                                    .build();

                            return chain.proceed(request);

                        });*/

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Const.apiURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public Api getApiServiceClient() {
        return retrofit.create(Api.class);
    }

}
