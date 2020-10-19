package com.example.interview.ui.feature.landing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interview.models.DoctorResponse;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {
    MainActivityRepository repository;
    MutableLiveData<DoctorResponse> apiResponseLiveData;

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

    void getResult() {
        apiResponseLiveData = repository.onGetDoctorList();
    }
}
