
package com.example.interview.data.doctor;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Doctor implements Serializable {

    private final static long serialVersionUID = -1532654263738134874L;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("hospital")
    @Expose
    private String hospital;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("speciality")
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
