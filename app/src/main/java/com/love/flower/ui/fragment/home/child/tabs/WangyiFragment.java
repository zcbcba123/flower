package com.love.flower.ui.fragment.home.child.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.love.flower.R;
import com.love.flower.adapter.WangyiAdapter;
import com.love.flower.contract.home.tabs.WangyiContract;
import com.love.flower.model.bean.wangyi.WangyiNewsItemBean;
import com.love.flower.presenter.WangyiPresenter;
import com.zs.mvpsdk.base.BasePresenter;
import com.zs.mvpsdk.base.fragment.BaseRecycleFragment;

import java.util.List;

import butterknife.BindView;

public class WangyiFragment extends BaseRecycleFragment<WangyiContract.WangyiPresenter>
        implements WangyiContract.IWangyiView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_wangyi)
    RecyclerView rvWangyi;

    private WangyiAdapter mWangyiAdapter;

    public static WangyiFragment newInstance() {
        Bundle args = new Bundle();
        WangyiFragment fragment = new WangyiFragment();
        fragment.setArguments(args);
        return fragment;
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
        return WangyiPresenter.newInstance();
    }

    @Override
    public void initUI(View view, Bundle savedInstanceState) {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mWangyiAdapter = new WangyiAdapter(R.layout.item_recycle_home);
        rvWangyi.setAdapter(mWangyiAdapter);
        rvWangyi.setLayoutManager(new LinearLayoutManager(mActivity));

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_wangyi;
    }

    @Override
    public void onLoadMoreRequested() {

    }

    @Override
    public void updateContentList(List<WangyiNewsItemBean> list) {
        //Logger.e(list.toString());
        if (mWangyiAdapter.getData().size()==0){
            initRecycleView(list);
        }else {
            mWangyiAdapter.addData(list);
        }
    }

    private void initRecycleView(List<WangyiNewsItemBean> list) {
        mWangyiAdapter = new WangyiAdapter(R.layout.item_recycle_home, list);
        rvWangyi.setAdapter(mWangyiAdapter);
    }

    @Override
    public void itemNotifyChanged(int position) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showLoadMoreError() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.loadLatestList();//第一次显示时请求最新的list
    }
}
