
package com.example.interview.data.doctor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DoctorResponse implements Serializable {

    private final static long serialVersionUID = 6237911234302710514L;
    @SerializedName("doctors")
    @Expose
    private List<Doctor> doctors = null;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

}
