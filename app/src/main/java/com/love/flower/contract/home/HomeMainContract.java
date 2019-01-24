package com.love.flower.contract.home;

import com.love.flower.BasePresenter;
import com.love.flower.IBaseFragment;
import com.love.flower.IBaseModel;

public interface HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel,IHomeMainView>{
        public abstract void getTabList();
    }
    interface IHomeMainModel extends IBaseModel{
        String[] getTabs();
    }
    interface IHomeMainView extends IBaseFragment{
        void showTabList(String[] tabs);
    }
}
