package com.love.flower.presenter;

import android.support.annotation.NonNull;

import com.love.flower.contract.home.tabs.ZhihuContract;
import com.love.flower.model.bean.zhihu.ZhihuDailyItemBean;
import com.love.flower.model.bean.zhihu.ZhihuDailyListBean;
import com.love.flower.model.home.tab.ZhihuModel;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class ZhihuPresenter extends ZhihuContract.ZhihuPresenter {
    /**
     * 日报日期
     */
    private String mDate;

    @NonNull
    public static ZhihuPresenter newInstance() {
        return new ZhihuPresenter();
    }

    @Override
    public void loadLatestList() {
        if (mIModel == null)
            return;

        mRxManager.register(mIModel.getDailyList().subscribe(new Consumer<ZhihuDailyListBean>() {
            @Override
            public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
                mDate = zhihuDailyListBean.getDate();
                Logger.e("mDate = " +mDate);
                if (mIView!=null)
                    mIView.updateContentList(zhihuDailyListBean.getStories());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null){
                    if (mIView.isVisiable())
                        mIView.showToast("Network error.");
                    mIView.showNetworkError();
                }
            }
        }));

    }

    @Override
    public void loadMoreList() {
    }

    @Override
    public void onItemClick(int position, ZhihuDailyItemBean item) {

    }

    @Override
    protected ZhihuContract.IZhihuModel getModel() {
        return ZhihuModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
