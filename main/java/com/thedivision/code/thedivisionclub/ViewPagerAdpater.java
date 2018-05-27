package com.thedivision.code.thedivisionclub;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/12 0012.
 */

public class ViewPagerAdpater extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> List_Show ;
    public ViewPagerAdpater(FragmentManager fm, ArrayList<Fragment> Show) {
        super(fm);
        this.List_Show = Show;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return List_Show.get(position);
    }

    @Override
    public int getCount() {
        return List_Show.size();
    }
}
