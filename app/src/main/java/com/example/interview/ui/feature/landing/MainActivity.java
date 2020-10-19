package com.example.interview.ui.feature.landing;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.interview.R;
import com.example.interview.core.base.BaseActivity;
import com.example.interview.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainActivityViewModel> {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    @Inject
    ViewModelProvider.Factory factory;
    private MainActivityViewModel viewModel;

    @Override
    public MainActivityViewModel getViewModel() {
        viewModel = new ViewModelProvider(this, factory).get(MainActivityViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel.getResult();
    }
}