package com.zz.cartton.hz.cartoon.fragment_everyday;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zz.cartton.hz.cartoon.R;

/**
 * 日常
 * */
public class EverydayFragement extends Fragment {

    private TextView EverydayTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_everyday,null);
//        EverydayTV= (TextView) view.findViewById(R.id.everyday_fragment_tv);



        return view;
    }
}
