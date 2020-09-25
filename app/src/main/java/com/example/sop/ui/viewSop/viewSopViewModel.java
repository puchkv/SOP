package com.example.sop.ui.viewSop;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Sop;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class viewSopViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<Sop> sopLiveData;

    public LiveData<Sop> getSop(int id) {
        if(sopLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            sopLiveData = new MutableLiveData<>();
            loadSop(id);
        }
        return sopLiveData;
    }

    public void loadSop(int id) {

        api.getSop(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Sop>() {
                    @Override
                    public void onSuccess(@NonNull Sop sop) {
                        sopLiveData.setValue(sop);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, "SopView View Model: " + e.getMessage());
                    }
                });
    }

}
