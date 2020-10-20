package com.example.interview.core.di.builder;

import com.example.interview.R;
import com.example.interview.core.di.modules.RoomModule;
import com.example.interview.ui.feature.landing.MainActivity;
import com.example.interview.ui.feature.landing.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(
            modules = {
                    MainActivityModule.class
            })
    abstract MainActivity contributeMainActivity();
}
