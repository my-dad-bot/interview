package com.example.interview.ui.feature.landing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interview.data.doctor.remote.DoctorResponse;

import javax.inject.Inject;

import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    MainActivityRepository repository;
    MutableLiveData<Response<DoctorResponse>> apiResponseLiveData;

    @Inject
    public MainActivityViewModel(MainActivityRepository repository) {
        this.repository = repository;
        apiResponseLiveData = this.repository.responseLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClearDisposable();
    }

    public void getResult() {
       apiResponseLiveData = repository.onGetDoctorList();
    }
}
