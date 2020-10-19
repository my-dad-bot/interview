package com.example.interview.ui.feature.landing;

import androidx.lifecycle.ViewModelProvider;

import com.example.interview.core.di.network.ApiServices;
import com.example.interview.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class MainActivityModule {

    @Provides
    ViewModelProvider.Factory provideMainActivityViewModelFactory(MainActivityViewModel viewModel) {
        return new ViewModelProviderFactory<>(viewModel);
    }

    @Provides
    CompositeDisposable procideLoginFragmentCompositeDisposal() {
        return new CompositeDisposable();
    }

    @Provides
    MainActivityRepository provideMainActivityRepository(ApiServices apiServices, CompositeDisposable disposable) {
        return new MainActivityRepository(apiServices, disposable);
    }

    @Provides
    MainActivityViewModel provideMainActivityViewModel(MainActivityRepository repository) {
        return new MainActivityViewModel(repository);
    }
}
