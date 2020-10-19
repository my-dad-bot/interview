package com.example.interview.core.di.component;

import android.app.Application;

import com.example.interview.core.base.BaseApplication;
import com.example.interview.core.di.builder.ActivityBuilder;
import com.example.interview.core.di.modules.AppModule;
import com.example.interview.core.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                AppModule.class,
                NetworkModule.class,
                ActivityBuilder.class

        }
)
public interface BaseComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        BaseComponent build();
    }
}
