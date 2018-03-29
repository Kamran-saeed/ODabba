package com.example.kamranchaudhary.odabba;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kamranchaudhary.odabba.APIs.PackageApi;
import com.example.kamranchaudhary.odabba.Adapters.RecylerAdapter;
import com.example.kamranchaudhary.odabba.Interfaces.PackageApiInterface;
import com.example.kamranchaudhary.odabba.Models.Package;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private RecylerAdapter recylerAdapter;
    RecyclerView.LayoutManager layoutManager;
    private PackageApiInterface packageApiInterface;
    public static List<Package> packagesList;
    public static boolean apiFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        if(!apiFlag) {
            packageApiInterface = PackageApi.getApiClent().create(PackageApiInterface.class);
            Call<List<Package>> call = packageApiInterface.getPackages();
            call.enqueue(new Callback<List<Package>>() {
                @Override
                public void onResponse(Call<List<Package>> call, Response<List<Package>> response) {
                    apiFlag = true;
                    packagesList = response.body();
                    Log.i("packages list", packagesList.get(1).getPackage_name());
                    recylerAdapter = new RecylerAdapter(getActivity(), packagesList);
                    recyclerView.setAdapter(recylerAdapter);
                }

                @Override
                public void onFailure(Call<List<Package>> call, Throwable t) {

                }
            });
        }
        else{
            recylerAdapter = new RecylerAdapter(getActivity(), packagesList);
            recyclerView.setAdapter(recylerAdapter);
        }

        return view;
    }


}