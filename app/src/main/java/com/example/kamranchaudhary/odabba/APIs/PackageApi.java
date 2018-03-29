package com.example.kamranchaudhary.odabba.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PackageApi {

    public static final String BASE_URL = "http:10.1.85.6:3000/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClent(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}