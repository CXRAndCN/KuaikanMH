package com.example.administrator.kuaikanmh.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.kuaikanmh.R;


/**
 * Created by aaa on 15-4-26.
 */
public class PersonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.person_fragment,container,false);

        return  view;
    }


}
