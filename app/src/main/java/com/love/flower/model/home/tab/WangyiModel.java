package com.love.flower.model.home.tab;

import android.support.annotation.NonNull;

import com.love.flower.api.WangyiApi;
import com.love.flower.contract.home.tabs.WangyiContract;
import com.love.flower.model.bean.wangyi.WangyiNewsListBean;
import com.zs.mvpsdk.helper.RetrofitCreateHelper;
import com.zs.mvpsdk.rxbus.RxHelper;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Horrarndoo on 2017/9/18.
 * <p>
 */

public class WangyiModel implements WangyiContract.IWangyiModel {
    @NonNull
    public static WangyiModel newInstance() {
        return new WangyiModel();
    }

    @Override
    public Observable<WangyiNewsListBean> getNewsList(int id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewsList(id)
                .compose(RxHelper.<WangyiNewsListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return null;
    }
}
