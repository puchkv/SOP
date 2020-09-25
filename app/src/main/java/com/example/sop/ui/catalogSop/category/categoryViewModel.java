package com.example.sop.ui.catalogSop.category;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Category;
import com.example.sop.models.Sector;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class categoryViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<List<Category>> categoriesLiveData;

    public LiveData<List<Category>> getSectorCategories(int id) {
        if(categoriesLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            categoriesLiveData = new MutableLiveData<>();
            loadSectorCategories(id);
        }
        return categoriesLiveData;
    }

    public void loadSectorCategories(int id) {

        api.getSectorCategories(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Category>>() {
                    @Override
                    public void onSuccess(@NonNull List<Category> categories) {
                        List<Category> categoriesList = new ArrayList<>(categories);
                        categoriesLiveData.setValue(categoriesList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, "Category View Model: " + e.getMessage());
                    }
                });
    }

}
