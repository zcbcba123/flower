package com.love.flower.ui.fragment.home.child.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.love.flower.R;
import com.love.flower.adapter.ZhihuAdapter;
import com.love.flower.contract.home.tabs.ZhihuContract;
import com.love.flower.model.bean.zhihu.ZhihuDailyItemBean;
import com.love.flower.presenter.ZhihuPresenter;
import com.zs.mvpsdk.base.BasePresenter;
import com.zs.mvpsdk.base.fragment.BaseRecycleFragment;

import java.util.List;
import java.util.logging.Logger;

import butterknife.BindView;

public class ZhihuFragment extends BaseRecycleFragment<ZhihuContract.ZhihuPresenter>implements
    ZhihuContract.IZhihuView,BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_zhihu)
    RecyclerView rvZhihu;

    private ZhihuAdapter mZhihuAdapter;

    public static ZhihuFragment newInstance(){
        Bundle args = new Bundle();
        ZhihuFragment fragment = new ZhihuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void updateContentList(List<ZhihuDailyItemBean> list)  {
        com.orhanobut.logger.Logger.e(list.toString());
        com.orhanobut.logger.Logger.e("     "+mZhihuAdapter.getData().size()+"");
        if (mZhihuAdapter.getData().size()==0){
            initRecycleView(list);
        }else {
            mZhihuAdapter.addData(list);
        }
    }

    @Override
    public void itemNotifyChanged(int position) {

    }

    @Override
    public void showNetworkError() {
        mZhihuAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    protected void onErrorViewClick(View view) {

    }

    @Override
    protected void showLoading() {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return ZhihuPresenter.newInstance();
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        mZhihuAdapter = new ZhihuAdapter(R.layout.item_recycle_home);
        rvZhihu.setAdapter(mZhihuAdapter);
        rvZhihu.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_zhihu;
    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();//第一次显示时请求最新的list
    }

    private void initRecycleView(List<ZhihuDailyItemBean> list){
        mZhihuAdapter = new ZhihuAdapter(R.layout.item_recycle_home, list);
        mZhihuAdapter.setOnLoadMoreListener(this,rvZhihu);

        rvZhihu.setAdapter(mZhihuAdapter);
    }
}
