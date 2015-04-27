package com.example.administrator.kuaikanmh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kuaikanmh.R;

/**
 * Created by aaa on 15-4-26.
 */
public class FondFragment  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fond_fragment,container,false);
        return   view;
    }
}
