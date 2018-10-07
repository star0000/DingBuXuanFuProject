package com.moyu.dingbuxuanfuproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.moyu.dingbuxuanfuproject.fragments.BaseFragment;

import java.util.List;

/**
 * Created by 墨羽 on 2018/9/23.
 */

public class FragmentsViewPagerAdapter extends FragmentPagerAdapter {

    private List<? extends BaseFragment> fragments;

    public FragmentsViewPagerAdapter(FragmentManager fm,
                                     List<? extends BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments != null && position < fragments.size() ? fragments.get(position).getTitle() : "";
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        return super.instantiateItem(container, position);
    }

}
