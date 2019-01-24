package com.love.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Horrarndoo on 2017/9/6.
 * <p>
 * Mvp Fragment基类
 * <p>
 * 实现IBaseView方法、绑定butterknife
 */
public abstract class BaseMVPCompatFragment <P extends BasePresenter>extends BaseCompatFragment implements IBaseFragment{
    public P mPresenter;

    /**
     * 在监听器之前把数据准备好
     */
    @Override
    public void initData() {
        super.initData();
        mPresenter= (P) initPresenter();
        if (mPresenter!=null){
            mPresenter.attachMV(this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachMV();
        }
    }



    @Override
    public void showWaitDialog(String waitMsg) {
    }
    @Override
    public void hideWaitDialog() {

    }
    @Override
    public void showToast(String msg) {

    }

    @Override
    public void back() {

    }



    @Override
    public void startNewFragment(@NonNull SupportFragment supportFragment) {

    }

    @Override
    public void startNewFragmentWithPop(@NonNull SupportFragment supportFragment) {

    }

    @Override
    public void startNewFragmentForResult(@NonNull SupportFragment supportFragment, int requestCode) {

    }

    @Override
    public void popToFragment(Class<?> targetFragmentClass, boolean includeTargetFragment) {

    }

    @Override
    public void hideKeybord() {

    }




    @Override
    public void setOnFragmentResult(int resultCode, Bundle data) {

    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {

    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {

    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {

    }

    @Override
    public boolean isVisiable() {
        return false;
    }

    @Override
    public Activity getBindActivity() {
        return null;
    }












}
