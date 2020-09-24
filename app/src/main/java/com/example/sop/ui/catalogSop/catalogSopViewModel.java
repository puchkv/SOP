package com.example.sop.ui.catalogSop;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Factory;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class catalogSopViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<List<Factory>> factoriesLiveData;

    public LiveData<List<Factory>> getFactories() {
        if(factoriesLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            factoriesLiveData = new MutableLiveData<>();
            loadFactories();
        }
        return factoriesLiveData;
    }

    public void loadFactories() {

        api.getFactories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<Factory>>() {
                    @Override
                    public void onNext(@NonNull List<Factory> factories) {

                        List<Factory> factoriesList = new ArrayList<>(factories);

                        factoriesLiveData.setValue(factoriesList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, Objects.requireNonNull(e.getLocalizedMessage()));
                    }

                    @Override
                    public void onComplete() {
                        for(Factory factory : Objects.requireNonNull(factoriesLiveData.getValue())) {
                            Log.i(Const.TAG, factory.getName());
                        }
                    }
                });
    }


}
