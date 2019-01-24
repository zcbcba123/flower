package com.love.flower.model.gankio;

import android.support.annotation.NonNull;

import com.love.flower.contract.gankio.GankIoMainContract;

public class GankIoMainModel implements GankIoMainContract.IGankIoMainModel{
    @NonNull
    public static GankIoMainModel newInstance() {
        return new GankIoMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"每日推荐", "干货定制", "福利"};
    }
}
