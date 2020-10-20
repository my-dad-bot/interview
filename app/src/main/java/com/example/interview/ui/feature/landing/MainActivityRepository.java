package com.example.interview.ui.feature.landing;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.interview.core.di.network.ApiServices;
import com.example.interview.data.doctor.DoctorResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityRepository {
    private static final String TAG = "MainActivityRepository";
    public MutableLiveData<DoctorResponse> responseLiveData = new MutableLiveData<>();
    private ApiServices apiServices;
    private CompositeDisposable disposable;

    @Inject
    public MainActivityRepository(ApiServices apiServices, CompositeDisposable disposable) {
        this.apiServices = apiServices;
        this.disposable = disposable;
    }

    MutableLiveData<DoctorResponse> onGetDoctorList() {
        Log.d(TAG, "onGetDoctorList: ");
        Single<DoctorResponse> observer = apiServices.onGetDoctorList();
        disposable.add(observer
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DoctorResponse>() {
                    @Override
                    public void onSuccess(DoctorResponse response) {
                        responseLiveData.postValue(response);
                        Log.d(TAG, "onSuccess: " + response.getDoctors());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }));
        return responseLiveData;
    }

    void onClearDisposable() {
        disposable.clear();
    }
}
