package com.example.interview.data.doctor.local;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.example.interview.utils.AppConstants.DOCTOR_ENTITY;

@Entity(tableName = DOCTOR_ENTITY)
public class DoctorEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "hospital")
    @Expose
    private String hospital;
    @ColumnInfo(name = "name")
    @Expose
    private String name;
    @ColumnInfo(name = "speciality")
    @Expose
    private String speciality;
    @ColumnInfo(name = "city")
    @Expose
    private String city;
    @ColumnInfo(name = "state")
    @Expose
    private String state;
    @ColumnInfo(name = "street")
    @Expose
    private String street;
    @ColumnInfo(name = "zip")
    @Expose
    private String zip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id=" + id +
                ", hospital='" + hospital + '\'' +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
