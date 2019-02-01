package com.love.flower.contract.home.tabs;

import com.love.flower.model.bean.zhihu.ZhihuDailyItemBean;
import com.love.flower.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;

public interface ZhihuContract {
    abstract class ZhihuPresenter extends BaseTabsContract.BaseTabsPresenter<IZhihuModel,IZhihuView,ZhihuDailyItemBean>{
    }

    interface IZhihuModel extends BaseTabsContract.IBaseTabsModel{
        /**
         * 根据日期获取日报list --> 20170910
         *
         * @param date 日期
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList(String date);

        /**
         * 获取日报list
         *
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList();
    }
    interface IZhihuView extends BaseTabsContract.IBaseTabsView<ZhihuDailyItemBean> {
    }
}
