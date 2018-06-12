package com.example.gaurav.egluremoteappui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gaurav.egluremoteappui.fragments.AcFragment;
import com.example.gaurav.egluremoteappui.fragments.LedFragment;
import com.example.gaurav.egluremoteappui.fragments.SettopBoxFragment;
import com.example.gaurav.egluremoteappui.fragments.TvFragment;

/**
 * Created by gaurav on 6/6/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment currentFrag = null;

        switch (position){
            case 0:
                currentFrag = new TvFragment();
                break;
            case 1:
                currentFrag = new AcFragment();
                break;
            case 2:
                currentFrag = new SettopBoxFragment();
                break;
            case 3:
                currentFrag = new LedFragment();
                break;

        }
        return currentFrag;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
