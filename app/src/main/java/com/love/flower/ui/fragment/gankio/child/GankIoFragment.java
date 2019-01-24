package com.love.flower.ui.fragment.gankio.child;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zs.mvpsdk.base.fragment.BaseMVPCompatFragment;
import com.zs.mvpsdk.base.BasePresenter;
import com.love.flower.R;
import com.love.flower.contract.gankio.GankIoMainContract;
import com.love.flower.presenter.GankIoMainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GankIoFragment extends BaseMVPCompatFragment<GankIoMainContract.GankIoMainPresenter> implements GankIoMainContract.IGankIoMainView {
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_classify)
    FloatingActionButton fabClassify;

    private List<Fragment> fragments;

    public static GankIoFragment newInstance() {
        Bundle args = new Bundle();
        GankIoFragment fragment = new GankIoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (vpFragment.getCurrentItem() == 1) {
                    if (verticalOffset == 0) {
                        fabClassify.show();
                    } else {
                        fabClassify.hide();
                    }
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return  R.layout.fragment_gank_io_;
    }
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTabList();
    }
    @Override
    public void showTabList(String[] tabs) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return GankIoMainPresenter.newInstance();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragments = new ArrayList<>();
    }
}
