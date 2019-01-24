package com.love.flower.model.home;

import android.support.annotation.NonNull;

import com.zs.mvpsdk.base.BaseModel;
import com.love.flower.contract.home.HomeMainContract;

public class HomeMainModel extends BaseModel implements HomeMainContract.IHomeMainModel {
    @NonNull
    public static HomeMainModel newInstance(){
        return new HomeMainModel();}

    @Override
    public String[] getTabs() {
        return new String[]{"知乎日报","热点新闻","微信精选"};
    }
}
