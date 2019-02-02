package com.love.flower.presenter;

import android.support.annotation.NonNull;

import com.love.flower.contract.home.tabs.WangyiContract;
import com.love.flower.model.bean.wangyi.WangyiNewsItemBean;
import com.love.flower.model.bean.wangyi.WangyiNewsListBean;
import com.love.flower.model.home.tab.WangyiModel;
import com.zs.mvpsdk.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

public class WangyiPresenter extends WangyiContract.WangyiPresenter {
    private int mCurrentIndex;
    private boolean isLoading;

    @NonNull
    public static WangyiPresenter newInstance(){return new WangyiPresenter();}


    @Override
    public void loadLatestList() {
            mCurrentIndex=0;
            mRxManager.register(mIModel.getNewsList(mCurrentIndex).subscribe(new Consumer<WangyiNewsListBean>() {
                @Override
                public void accept(WangyiNewsListBean wangyiNewsListBean) throws Exception {
                    if (mIView !=null){
                        List<WangyiNewsItemBean> list = wangyiNewsListBean.getNewsList();
                        for (int i=0;i<list.size();i++){
                            //过滤掉无效的新闻
                            if (StringUtils.isEmpty(list.get(i).getUrl())) {
                                list.remove(i);
                            }
                        }
                        mCurrentIndex +=20;
                        mIView.updateContentList(list);
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {

                }
            }));
    }

    @Override
    public void loadMoreList() {

    }

    @Override
    public void onItemClick(int position, WangyiNewsItemBean item) {

    }

    @Override
    protected WangyiContract.IWangyiModel getModel() {
        return WangyiModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
