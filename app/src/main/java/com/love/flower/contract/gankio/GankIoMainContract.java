package com.love.flower.contract.gankio;

import com.zs.mvpsdk.base.BasePresenter;
import com.zs.mvpsdk.base.IBaseFragment;
import com.zs.mvpsdk.base.IBaseModel;

public interface GankIoMainContract {
    //主页接口
    abstract class GankIoMainPresenter extends BasePresenter<IGankIoMainModel, IGankIoMainView> {
        public abstract void getTabList();
    }

    interface IGankIoMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IGankIoMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }
}
