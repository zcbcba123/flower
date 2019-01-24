package com.love.flower.ui.fragment.gankio;

import android.os.Bundle;
import android.view.View;

import com.zs.mvpsdk.base.fragment.BaseCompatFragment;
import com.love.flower.R;
import com.love.flower.ui.fragment.gankio.child.GankIoFragment;

public class GankIoRootFragment extends BaseCompatFragment {
    public static GankIoRootFragment newInstance(){
        Bundle args = new Bundle();
        GankIoRootFragment fragment = new GankIoRootFragment();
        return fragment;
    }
    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        if (findChildFragment(GankIoRootFragment.class)==null) {
            loadRootFragment(R.id.fl_container,GankIoFragment.newInstance());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io;
    }

}
