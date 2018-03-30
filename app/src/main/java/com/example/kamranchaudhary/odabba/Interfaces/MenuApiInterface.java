package com.example.kamranchaudhary.odabba.Interfaces;


import com.example.kamranchaudhary.odabba.Models.Menu;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApiInterface {

    @GET("api/get_menu")
    Call<List<Menu>> getMenu();
}
