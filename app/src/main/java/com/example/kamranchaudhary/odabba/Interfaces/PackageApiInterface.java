package com.example.kamranchaudhary.odabba.Interfaces;

import com.example.kamranchaudhary.odabba.Models.Package;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PackageApiInterface {

    @GET("api/getall_package")
    Call<List<Package>> getPackages();
}