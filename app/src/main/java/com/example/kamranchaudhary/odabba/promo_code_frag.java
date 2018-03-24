package com.example.kamranchaudhary.odabba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class promo_code_frag extends Fragment {

    View my_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        my_view = inflater.inflate(R.layout.fragment_promo_code,container,false);

        return my_view;
    }
}
