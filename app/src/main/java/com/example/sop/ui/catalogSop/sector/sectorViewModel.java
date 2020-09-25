package com.example.sop.ui.catalogSop.sector;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Department;
import com.example.sop.models.Sector;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class sectorViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<List<Sector>> sectorsLiveData;

    public LiveData<List<Sector>> getFactoryDepartments(int id) {
        if(sectorsLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            sectorsLiveData = new MutableLiveData<>();
            loadDepartmentSectors(id);
        }
        return sectorsLiveData;
    }

    public void loadDepartmentSectors(int id) {

        api.getDepartmentSectors(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Sector>>() {
                    @Override
                    public void onSuccess(@NonNull List<Sector> sectors) {
                        List<Sector> sectorsList = new ArrayList<>(sectors);

                        sectorsLiveData.setValue(sectorsList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, "Sector View Model: " + e.getMessage());
                    }
                });
    }


}