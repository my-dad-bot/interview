package com.example.interview.core.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.interview.core.base.BaseApplication;
import com.example.interview.utils.Preference;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    Preference provideSharedHelper(Context context) {
        return new Preference(context);
    }
}
