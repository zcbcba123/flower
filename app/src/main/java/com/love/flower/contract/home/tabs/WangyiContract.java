package com.love.flower.contract.home.tabs;

import com.love.flower.model.bean.wangyi.WangyiNewsItemBean;
import com.love.flower.model.bean.wangyi.WangyiNewsListBean;
import com.zs.mvpsdk.base.BasePresenter;

import io.reactivex.Observable;


public interface WangyiContract {
    abstract class WangyiPresenter extends BaseTabsContract.BaseTabsPresenter<IWangyiModel,IWangyiView,WangyiNewsItemBean>{

    }
    interface IWangyiModel extends BaseTabsContract.IBaseTabsModel{
        /**
         * 获取网易新闻list
         *
         * @param id id
         * @return Observable
         */
        Observable<WangyiNewsListBean> getNewsList(int id);
    }

    interface IWangyiView extends BaseTabsContract.IBaseTabsView<WangyiNewsItemBean>{

    }
}
