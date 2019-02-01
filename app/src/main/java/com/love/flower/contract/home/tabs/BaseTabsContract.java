package com.love.flower.contract.home.tabs;

import com.zs.mvpsdk.base.BasePresenter;
import com.zs.mvpsdk.base.IBaseFragment;
import com.zs.mvpsdk.base.IBaseModel;

import java.util.List;

import io.reactivex.Observable;

public interface BaseTabsContract {
    abstract class BaseTabsPresenter<M extends IBaseTabsModel,V extends IBaseTabsView,T>
            extends BasePresenter<M,V>{
        /**
         * 加载最新的list
         */
        public abstract void loadLatestList();
        /**
         * 加载更多list
         */
        public abstract void loadMoreList();
        /**
         * item点击事件
         *
         * @param position position
         * @param item     item
         */
        public abstract void onItemClick(int position, T item);
    }
    interface IBaseTabsModel extends IBaseModel{
        /**
         * 记录item已阅到数据库
         * @param key
         * @return key(item.id值作为key)
         */
        Observable<Boolean> recordItemIsRead(String key);
    }

    interface IBaseTabsView<L> extends IBaseFragment{
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(List<L> list);

        /**
         * 点击事件后，刷新item
         *
         * @param position position
         */
        void itemNotifyChanged(int position);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载更多错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据
         */
        void showNoMoreData();
    }
}
