package com.example.interview.core.base;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewModel> extends DaggerFragment {

    public abstract T getViewModel();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        T viewModel = getViewModel();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}