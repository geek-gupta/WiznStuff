package com.example.gaurav.egluremoteappui.fragments;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import  android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gaurav.egluremoteappui.R;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaurav on 6/6/2018.
 */

public class TvFragment extends Fragment implements View.OnClickListener{

    private ImageButton dialpadImageBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tvView = inflater.inflate(R.layout.tv_fragment_layout, container, false);

        dialpadImageBtn = tvView.findViewById(R.id.dialpad);
        dialpadImageBtn.setOnClickListener(this);

        return tvView;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialpad:
                GridView gridView = new GridView(getContext());
                final List<String> mList = new ArrayList<>();
                for(int i = 1; i<10; i++){
                    mList.add(""+i);
                }
                mList.add("-");
                mList.add("0");
                mList.add("<-");
                gridView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mList));
                gridView.setNumColumns(3);
                gridView.setGravity(Gravity.CENTER_HORIZONTAL);
                gridView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getContext(), mList.get(i), Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(gridView);
                builder.show();
                break;

        }
    }
}
