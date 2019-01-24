package com.love.flower.ui.fragment.home;

import android.os.Bundle;
import android.view.View;

import com.zs.mvpsdk.base.fragment.BaseCompatFragment;
import com.love.flower.R;
import com.love.flower.ui.fragment.home.child.HomeFragment;

public class HomeRootFragment extends BaseCompatFragment {
    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        if (findChildFragment(HomeRootFragment.class)==null){
            loadRootFragment(R.id.fl_container,HomeFragment.newInstance());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
