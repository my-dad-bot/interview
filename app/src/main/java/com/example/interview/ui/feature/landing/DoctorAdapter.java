package com.example.interview.ui.feature.landing;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interview.R;
import com.example.interview.data.doctor.remote.Doctor;
import com.example.interview.databinding.ItemDoctorBinding;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    List<Doctor> list = new ArrayList<Doctor>();
    private static final String TAG = "DoctorAdapter";

    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDoctorBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_doctor, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.ViewHolder holder, int position) {
        
        
        Log.v (TAG, "From Activity: "+list.get(position).getName());
        holder.binding.materialTextViewName.setText(list.get(position).getName());
        holder.binding.materialTextViewHospitalName.setText(list.get(position).getHospital());
        holder.binding.materialTextViewSpeciality.setText(list.get(position).getSpeciality());

    }

    public void setData(List<Doctor> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemDoctorBinding binding;

        public ViewHolder(ItemDoctorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
