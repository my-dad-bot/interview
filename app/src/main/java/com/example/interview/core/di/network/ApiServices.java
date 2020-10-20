package com.example.interview.core.di.network;

import com.example.interview.data.doctor.remote.DoctorResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("q/pTUuXPKj?token=-7tj8JQnZTDTm4tM-ETnBg")
    Observable<Response<DoctorResponse>> onGetDoctorList();
}
