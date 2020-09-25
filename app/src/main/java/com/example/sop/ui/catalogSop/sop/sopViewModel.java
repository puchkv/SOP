package com.example.sop.ui.catalogSop.sop;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Category;
import com.example.sop.models.Sop;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class sopViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<List<Sop>> sopLiveData;

    public LiveData<List<Sop>> getCategorySops(int id) {
        if(sopLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            sopLiveData = new MutableLiveData<>();
            loadCategorySops(id);
        }
        return sopLiveData;
    }

    public void loadCategorySops(int id) {

        api.getCategorySops(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Sop>>() {
                    @Override
                    public void onSuccess(@NonNull List<Sop> sops) {
                        List<Sop> sopList = new ArrayList<>(sops);
                        sopLiveData.setValue(sopList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, "Catalog SOP View Model: " + e.getMessage());
                    }
                });
    }

}

