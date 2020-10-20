package com.example.interview.core.base;



import com.example.interview.core.di.component.DaggerBaseComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {
    
    private static final String TAG = BaseApplication.class.getSimpleName();
    private static BaseApplication instance;

    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerBaseComponent.builder().application(this).build();
    }
}