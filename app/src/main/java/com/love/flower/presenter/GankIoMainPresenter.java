package com.love.flower.presenter;

import android.support.annotation.NonNull;

import com.love.flower.contract.gankio.GankIoMainContract;
import com.love.flower.model.gankio.GankIoMainModel;

public class GankIoMainPresenter extends GankIoMainContract.GankIoMainPresenter {
    @NonNull
    public static GankIoMainPresenter newInstance() {
        return new GankIoMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected GankIoMainContract.IGankIoMainModel getModel() {
        return GankIoMainModel.newInstance();
    }

    @Override
    public void onStart() {
        //getTabList();
    }
}
