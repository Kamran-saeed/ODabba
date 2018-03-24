package com.example.kamranchaudhary.odabba;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kamran Chaudhary on 14-Mar-18.
 */

public class My_Subs_Fragment extends Fragment {

    View my_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        my_view = inflater.inflate(R.layout.my_subscription,container,false);
        return my_view;
    }
}
