package com.love.flower.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.love.flower.MyApplication;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        initView(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected void initData() {
        mContext = MyApplication.getContext();
    }
}
