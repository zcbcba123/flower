package com.love.flower;

import android.content.Context;
import android.os.Bundle;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseCompatActivity extends SupportActivity {
    protected Context mContext;
    protected MyApplication mApplcation;

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
