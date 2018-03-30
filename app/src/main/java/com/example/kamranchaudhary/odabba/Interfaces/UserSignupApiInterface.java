package com.example.kamranchaudhary.odabba.Interfaces;

import com.example.kamranchaudhary.odabba.Models.Address;
import com.example.kamranchaudhary.odabba.Models.UserSignup;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSignupApiInterface {

    @POST("api/insert_user")
    Call<UserSignup> signupUser(@Body UserSignup user);

    @POST("api/insert_address")
    Call<Address> insertUserAddress(@Body Address address);
}
