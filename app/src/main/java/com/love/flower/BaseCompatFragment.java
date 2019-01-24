package com.love.flower;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseCompatFragment extends SupportFragment {
    protected String TAG;
    protected Context mContext;
    protected Activity mActivity;
    protected MyApplication mApplication;
    protected Unbinder binder;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG = getClass().getSimpleName();
        binder = ButterKnife.bind(this, view);
        getBundle(getArguments());
        initData();
        initUI(view, savedInstanceState);
    }

    /**
     * 初始化UI
     */
    public abstract void initUI(View view, Bundle savedInstanceState);


    /**
     * 在监听器之前把数据准备好
     */
    public void initData() {
        mContext = AppUtils.getContext();
        mApplication = (MyApplication) mActivity.getApplication();
    }

    /**
     * 得到Activity传进来的值
     */
    public void getBundle(Bundle bundle) {
    }

    @LayoutRes
    public abstract int getLayoutId();
    /**
     * 处理回退事件
     *
     * @return true 事件已消费
     * <p>
     * false 事件向上传递
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getFragmentManager().getBackStackEntryCount()>1){
            //如果当前存在fragment>1，当前fragment出栈
            pop();
        }else{
            //已经退栈到root fragment，交由Activity处理回退事件
            return false;
        }
        return true;
    }
}
