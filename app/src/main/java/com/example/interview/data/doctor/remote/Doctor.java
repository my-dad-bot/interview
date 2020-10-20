
package com.example.interview.data.doctor.remote;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.interview.data.AddressTypeConvertion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static com.example.interview.utils.AppConstants.DOCTOR_ENTITY;

@Entity(tableName = DOCTOR_ENTITY)
public class Doctor implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;
    @SerializedName("address")
    @Expose
    @TypeConverters({AddressTypeConvertion.class})
    public Address address;
    @SerializedName("hospital")
    @ColumnInfo(name = "hospital")
    @Expose
    private String hospital;
    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;
    @SerializedName("speciality")
    @ColumnInfo(name = "speciality")
    @Expose
    private String speciality;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

}
