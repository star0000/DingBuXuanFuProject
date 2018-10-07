package com.moyu.dingbuxuanfuproject.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.gxz.PagerSlidingTabStrip;
import com.moyu.dingbuxuanfuproject.R;
import com.moyu.dingbuxuanfuproject.StickyNavLayout;
import com.moyu.dingbuxuanfuproject.adapter.FragmentsViewPagerAdapter;
import com.moyu.dingbuxuanfuproject.fragments.BaseFragment;
import com.moyu.dingbuxuanfuproject.fragments.EmptyListViewFragment;
import com.moyu.dingbuxuanfuproject.fragments.GridViewWithHeaderAndFooterFragment;
import com.moyu.dingbuxuanfuproject.fragments.ListViewFragment;
import com.moyu.dingbuxuanfuproject.fragments.RecycleViewFragment;
import com.moyu.dingbuxuanfuproject.fragments.ScrollViewFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    @Bind(R.id.id_stickynavlayout_indicator)
    PagerSlidingTabStrip pagerSlidingTabStrip;
    @Bind(R.id.id_stickynavlayout_viewpager)
    ViewPager viewPager;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.id_stick)
    StickyNavLayout stickyNavLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        ButterKnife.bind(this);

        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(ListViewFragment.newInstance());
        fragments.add(RecycleViewFragment.newInstance());
        fragments.add(EmptyListViewFragment.newInstance());
        fragments.add(ScrollViewFragment.newInstance());
        fragments.add(GridViewWithHeaderAndFooterFragment.newInstance());

        FragmentsViewPagerAdapter adapter = new FragmentsViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
        pagerSlidingTabStrip.setOnPageChangeListener(mPageChangeListener);

//        swipeRefreshLayout.setColorSchemeResources(R.color.swipe_color_1,
//                R.color.swipe_color_2,
//                R.color.swipe_color_3,
//                R.color.swipe_color_4);

        swipeRefreshLayout.setColorSchemeResources(R.color.swipe_color_5,
                R.color.swipe_color_6);

        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.swipe_color_1);
//        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.swipe_background_color);
//        swipeRefreshLayout.setPadding(20, 20, 20, 20);
//        swipeRefreshLayout.setProgressViewOffset(true, 100, 200);
//        swipeRefreshLayout.setDistanceToTriggerSync(50);
//        swipeRefreshLayout.setProgressViewEndTarget(true, 100);

        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        stickyNavLayout.setOnStickStateChangeListener(onStickStateChangeListener);
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }, 2000);
        }
    };

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
    private StickyNavLayout.onStickStateChangeListener onStickStateChangeListener = new StickyNavLayout.onStickStateChangeListener() {
        @Override
        public void isStick(boolean isStick) {

        }

        @Override
        public void scrollPercent(float percent) {
            if (percent==0) {
                swipeRefreshLayout.setEnabled(true);
                swipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
            } else {
                swipeRefreshLayout.setEnabled(false);
                swipeRefreshLayout.setOnRefreshListener(null);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
