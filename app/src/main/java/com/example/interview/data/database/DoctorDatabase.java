package com.example.interview.data.database;

import androidx.room.Database;

import com.example.interview.data.doctor.Doctor;

//@Database(entities = {Doctor.class}, version = DoctorDatabase.VERSION, exportSchema = false)
public abstract class DoctorDatabase {
    static final int VERSION = 1;
    public abstract DoctorDao getProductDao();
}
