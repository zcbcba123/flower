package com.love.flower.ui.fragment.home.child;

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

import com.love.flower.BaseMVPCompatFragment;
import com.love.flower.BasePresenter;
import com.love.flower.R;
import com.love.flower.ToastUtils;
import com.love.flower.constant.TabFragmentIndex;
import com.love.flower.contract.home.HomeMainContract;
import com.love.flower.presenter.HomeMainPresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseMVPCompatFragment<HomeMainContract.HomeMainPresenter>
        implements HomeMainContract.IHomeMainView {
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_download)
    FloatingActionButton fabDownload;
    protected OnOpenDrawerLayoutListener onOpenDrawerLayoutListener;
    private List<Fragment>fragments;
    public static HomeFragment newInstance(){
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOpenDrawerLayoutListener){
            onOpenDrawerLayoutListener = (OnOpenDrawerLayoutListener) context;
        }
        fragments = new ArrayList<>();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onOpenDrawerLayoutListener = null;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.getTabList();
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOpenDrawerLayoutListener!=null){
                    onOpenDrawerLayoutListener.onOpen();
                }
            }
        });
        //appBar偏移
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset==0){
                    fabDownload.show();
                }else {
                    fabDownload.hide();
                }
            }
        });
        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("web");
            }
        });
        toolbar.inflateMenu(R.menu.toolbar_menu);
//        toolbar.getMenu().findItem(R.id.night).setChecked()

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomeMainPresenter.newInstance();
    }

    @Override
    public void showTabList(String[] tabs) {
        Logger.w(Arrays.toString(tabs));
        for (int i=0;i<tabs.length;i++){
            tlTabs.addTab(tlTabs.newTab().setText(tabs[i]));
//            switch (i){
//                case TabFragmentIndex.TAB_ZHIHU_INDEX:
//                    fragments.add()
//            }
        }
    }

    /**
     * fragment打开DrawerLayout监听
     */
    public interface OnOpenDrawerLayoutListener {
        void onOpen();
    }
}
