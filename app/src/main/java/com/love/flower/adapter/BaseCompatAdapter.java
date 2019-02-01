package com.love.flower.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.love.flower.ui.widgets.RvLoadMoreView;

import java.util.List;

public abstract class BaseCompatAdapter<T,K extends BaseViewHolder> extends BaseQuickAdapter<T,K> {
    public BaseCompatAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        init();
    }

    public BaseCompatAdapter(@Nullable List<T> data) {
        super(data);
        init();
    }

    public BaseCompatAdapter(int layoutResId) {
        super(layoutResId);
        init();
    }
    private void init(){
        setLoadMoreView(new RvLoadMoreView());
        setEnableLoadMore(true);
        openLoadAnimation();//开启默认动画载入（仅开启加载新item时开启动画）
    }
}
