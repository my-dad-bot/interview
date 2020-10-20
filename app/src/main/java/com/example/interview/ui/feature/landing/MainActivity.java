package com.example.interview.ui.feature.landing;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.interview.R;
import com.example.interview.core.base.BaseActivity;
import com.example.interview.data.doctor.Doctor;
import com.example.interview.data.doctor.DoctorResponse;
import com.example.interview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainActivityViewModel> {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;

    @Inject
    ViewModelProvider.Factory factory;

    @Inject
    DoctorAdapter adapter;

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

        initRecyclerView();

        /*
        * Keeping eye on data passed from ViewModel and binding it with adapter
        * */
        viewModel.apiResponseLiveData.observe(this, new Observer<DoctorResponse>() {
            @Override
            public void onChanged(DoctorResponse doctorResponse) {
                adapter.setData(doctorResponse.getDoctors());
            }
        });
    }

    private void initRecyclerView(){
        binding.recyclerViewDoctorList.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewDoctorList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.recyclerViewDoctorList.setAdapter(adapter);
    }
}