package com.zz.cartton.hz.cartoon.fragment_find;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zz.cartton.hz.cartoon.R;

/**
 *查找漫画
 * */
public class FindCartoonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_find_cartoon,null);

        return view;
    }
}
