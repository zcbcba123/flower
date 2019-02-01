package com.love.flower.model.home.tab;

import android.support.annotation.NonNull;

import com.love.flower.api.ZhihuApi;
import com.love.flower.contract.home.tabs.ZhihuContract;
import com.love.flower.model.bean.zhihu.ZhihuDailyListBean;
import com.zs.mvpsdk.base.BaseModel;
import com.zs.mvpsdk.helper.RetrofitCreateHelper;
import com.zs.mvpsdk.rxbus.RxHelper;

import io.reactivex.Observable;

public class ZhihuModel extends BaseModel implements ZhihuContract.IZhihuModel {

    @NonNull
    public static ZhihuModel newInstance(){
        return new ZhihuModel();
    }
    @Override
    public Observable<ZhihuDailyListBean> getDailyList(String date) {
        return null;
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList() {
        return RetrofitCreateHelper.createApi(ZhihuApi.class,ZhihuApi.HOST).getLastDailyList()
                .compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        return null;
    }
}
