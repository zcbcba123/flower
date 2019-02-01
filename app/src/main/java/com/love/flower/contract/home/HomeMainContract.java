package com.love.flower.contract.home;

import com.zs.mvpsdk.base.BasePresenter;
import com.zs.mvpsdk.base.IBaseFragment;
import com.zs.mvpsdk.base.IBaseModel;
import com.zs.mvpsdk.base.IBaseView;

public interface HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel,IHomeMainView>{
        public abstract void getTabList();
    }
//    abstract class HomeMainPresenter <M extends IHomeMainModel,V extends IHomeMainView,T> extends BasePresenter<M,V> {
//                public abstract void getTabList();
//    }
    interface IHomeMainModel extends IBaseModel{
        String[] getTabs();
    }
    interface IHomeMainView extends IBaseFragment{
        void showTabList(String[] tabs);
    }
}
