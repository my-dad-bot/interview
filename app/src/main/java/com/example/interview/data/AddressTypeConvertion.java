package com.example.interview.data;

import androidx.room.TypeConverter;

import com.example.interview.data.doctor.remote.Address;
import com.google.gson.Gson;

public class AddressTypeConvertion {

    @TypeConverter
    public static String addressToString(Address address) {
        return new Gson().toJson(address);
    }

    @TypeConverter
    public static Address stringToAddress(String address) {
        return new Gson().fromJson(address, Address.class);
    }
}
