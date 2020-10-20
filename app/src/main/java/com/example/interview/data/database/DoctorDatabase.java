package com.example.interview.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.interview.data.doctor.remote.Doctor;

@Database(entities = {Doctor.class}, version = DoctorDatabase.VERSION, exportSchema = false)
public abstract class DoctorDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract DoctorDao getDoctorDao();
}
