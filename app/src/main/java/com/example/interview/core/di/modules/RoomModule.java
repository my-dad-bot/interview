package com.example.interview.core.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.interview.data.database.DoctorDao;
import com.example.interview.data.database.DoctorDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.interview.utils.AppConstants.DATABASE_NAME;

@Module
public class RoomModule {


    @Singleton
    @Provides
    public DoctorDatabase provideDoctorDatabase(Application application){
        return Room.databaseBuilder(application, DoctorDatabase.class, DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    public DoctorDao provideDoctorDao(DoctorDatabase database){
        return database.getDoctorDao();
    }
}
