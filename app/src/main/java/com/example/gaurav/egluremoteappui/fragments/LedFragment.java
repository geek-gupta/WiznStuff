package com.example.gaurav.egluremoteappui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.egluremoteappui.R;

/**
 * Created by gaurav on 6/11/2018.
 */

public class LedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.led_strip_fragment, container, false);
        return view;
    }
}
