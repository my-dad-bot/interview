package com.example.interview.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.interview.data.doctor.remote.Doctor;

import java.util.List;

import static com.example.interview.utils.AppConstants.DOCTOR_ENTITY;


@Dao
public interface DoctorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Doctor> doctorEntities);

    @Query("DELETE FROM " + DOCTOR_ENTITY)
    void deleteAll();

}
