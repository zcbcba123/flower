package com.love.flower.presenter;

import android.support.annotation.NonNull;

import com.love.flower.contract.home.HomeMainContract;
import com.love.flower.model.home.HomeMainModel;

public class HomeMainPresenter extends HomeMainContract.HomeMainPresenter {

    @NonNull
    public static HomeMainPresenter newInstance() {
        return new HomeMainPresenter();
    }

    @Override
    public void getTabList() {
        if ((mIView == null || mIModel == null))
            return;
        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected HomeMainContract.IHomeMainModel getModel() {
        return HomeMainModel.newInstance();
    }

    @Override
    public void onStart() {

    }


}
