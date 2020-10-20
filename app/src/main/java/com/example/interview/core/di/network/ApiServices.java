package com.example.interview.core.di.network;

import com.example.interview.data.doctor.DoctorResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("q/pTUuXPKj?token=-7tj8JQnZTDTm4tM-ETnBg")
    Single<DoctorResponse> onGetDoctorList();
}
