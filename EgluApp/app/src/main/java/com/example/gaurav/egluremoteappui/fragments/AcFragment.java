package com.example.gaurav.egluremoteappui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.gaurav.egluremoteappui.R;

/**
 * Created by gaurav on 6/6/2018.
 */

public class AcFragment extends Fragment {

    private Spinner mSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View acView =  inflater.inflate(R.layout.ac_fragment_layout, container, false);
        return acView;
    }


}
