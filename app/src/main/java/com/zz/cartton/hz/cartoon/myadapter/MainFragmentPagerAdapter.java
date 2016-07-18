package com.zz.cartton.hz.cartoon.myadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by my on 2016/7/15.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    //碎片适配器
    private List<Fragment> fragmentList;
    public MainFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    //初始化position位置的界面
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //返回碎片个数
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
