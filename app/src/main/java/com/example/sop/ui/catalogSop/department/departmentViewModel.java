package com.example.sop.ui.catalogSop.department;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sop.api.Api;
import com.example.sop.api.ApiService;
import com.example.sop.api.Const;
import com.example.sop.models.Department;
import com.example.sop.models.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class departmentViewModel extends ViewModel {

    private Api api;

    private MutableLiveData<List<Department>> departmentsLiveData;

    public LiveData<List<Department>> getFactoryDepartments(int factory_id) {
        if(departmentsLiveData == null) {
            api = ApiService.getInstance().getApiServiceClient();
            departmentsLiveData = new MutableLiveData<>();
            loadFactoryDepartments(factory_id);
        }
        return departmentsLiveData;
    }

    public void loadFactoryDepartments(int factory_id) {

        api.getFactoryDepartments(factory_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Department>>() {
                    @Override
                    public void onSuccess(@NonNull List<Department> departments) {
                        List<Department> departmentsList = new ArrayList<>(departments);

                        departmentsLiveData.setValue(departmentsList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(Const.TAG, "Department View Model: " + e.getMessage());
                    }
                });
    }

}
