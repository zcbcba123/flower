package com.love.flower;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MotionEvent;
import android.view.View;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class BaseCompatActivity extends SupportActivity {
    protected Context mContext;
    protected MyApplication mApplcation;
    static {
        //5.0以下兼容vector
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        //fragment切换使用默认Vertical动画
        return new DefaultVerticalAnimator();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                View view = getCurrentFocus();
//                AppUtils.hideKeyboard(ev,view,this);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void init(Bundle savedInstanceState) {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        initView(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected void initData() {
        mContext = AppUtils.getContext();
        Application application = getApplication();
    }

    /**
     * [页面跳转]
     *
     * @param clz 要跳转的Activity
     */
    public void startActivity(Class<?>clz){
        startActivity(new Intent(this,clz));
    }


    /**
     * [页面跳转]
     *
     * @param clz    要跳转的Activity
     * @param intent intent
     */
    public void startActivity(Class<?>clz,Intent intent){
        intent.setClass(this, clz);
        startActivity(intent);
    }

    /**
     * [携带数据的页面跳转]
     * @param clz    要跳转的Activity
     * @param bundle bundel数据
     */
    public void startActivity(Class<?>clz,Bundle bundle){
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param clz         要跳转的Activity
     * @param bundle      bundel数据
     * @param requestCode requestCode
     */
    public void startActivityForResult(Class<?> clz, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
