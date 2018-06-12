package com.example.gaurav.egluremoteappui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/6/2018.
 */
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    private ViewPager viewPager;
    private ActionBar actionBar;
    private TabsPagerAdapter pagerAdapter;
    private ArrayList<String> tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =  findViewById(R.id.view_pager);
        actionBar = getSupportActionBar();
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        if(actionBar!=null)
            actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
        tabs = new ArrayList<>();
        tabs.add("TV");
        tabs.add("AC");
        tabs.add("Settop Box");
        tabs.add("LED");
        for (String curr:tabs) {
            actionBar.addTab(actionBar.newTab().
                    setText(curr).setTabListener(MainActivity.this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
