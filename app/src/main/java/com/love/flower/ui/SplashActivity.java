package com.love.flower.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.love.flower.BaseCompatActivity;
import com.love.flower.MainActivity;
import com.love.flower.R;
import com.love.flower.RxHelper;
import com.love.flower.StringUtils;
import com.love.flower.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class SplashActivity extends BaseCompatActivity {
    @BindView(R.id.ll_skip)
    LinearLayout llSkip;
    @BindView(R.id.tv_count_down)
    TextView tvCountDown;
    private int mTime = 3;
    private boolean mIsCancle;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onBackPressedSupport() {
//        super.onBackPressedSupport();
        mIsCancle = true;
//        setIsTransAnim(false);
        finish();
    }



    @OnClick(R.id.ll_skip)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_skip:
                mIsCancle = true;
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //注：魅族pro6s-7.0-flyme6权限没有像类似6.0以上手机一样正常的提示dialog获取运行时权限，而是直接默认给了权限
        requestPermissions();
    }

    private void requestPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        //请求权限全部结果
        rxPermissions.request(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (!granted) {
                            ToastUtils.showToast("App未能获取全部需要的相关权限，部分功能可能不能正常使用.");
                        }
                        //不管是否获取全部权限，进入主页面
                        initCountDown();
                    }
                });
    }

    private void initCountDown() {
        Observable.interval(1, TimeUnit.SECONDS)//1秒一次
                .take(4)//计时次数，一共三次
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mTime - aLong;// 3-0 3-1 3-2
                    }
                })
                .compose(RxHelper.<Long>rxSchedulerHelper())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {
                        String s = String.valueOf(value);
                        if (tvCountDown != null) {
                            if (llSkip != null && (llSkip.getVisibility() == View.INVISIBLE))
                                llSkip.setVisibility(View.VISIBLE);
                            if (!"0".equals(s)) {
                                tvCountDown.setText(StringUtils.isEmpty(s) ? "" : s);
                            }
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (!mIsCancle) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }

}
