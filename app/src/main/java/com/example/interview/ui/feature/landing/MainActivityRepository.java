package com.example.interview.ui.feature.landing;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.interview.core.di.network.ApiServices;
import com.example.interview.data.database.DoctorDao;
import com.example.interview.data.doctor.remote.Doctor;
import com.example.interview.data.doctor.remote.DoctorResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivityRepository {
    private static final String TAG = "MainActivityRepository";
    public MutableLiveData<Response<DoctorResponse>> responseLiveData = new MutableLiveData<Response<DoctorResponse>>();
    private ApiServices apiServices;
    private CompositeDisposable disposable;
    DoctorDao doctorDao;

    @Inject
    public MainActivityRepository(ApiServices apiServices, CompositeDisposable disposable, DoctorDao dao) {
        this.apiServices = apiServices;
        this.disposable = disposable;
        this.doctorDao = dao;
    }

    MutableLiveData<Response<DoctorResponse>> onGetDoctorList() {
        Log.d(TAG, "onGetDoctorList: ");

        disposable.add(apiServices.onGetDoctorList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    if (response.isSuccessful() && response.body() != null) {
                        responseLiveData.postValue(response);
                        /*
                        Somehow this part is not working
                        * */
                        doctorDao.insert(response.body().getDoctors());
                    }else if (response.code() == 400){

                    }
                }, t -> {
                    //activity.view.onHideProgress();
                    //activity.handleThrowable(t);
                }));
        return responseLiveData;

    }

    void onClearDisposable() {
        disposable.clear();
    }
}
