package com.love.flower;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxHelper {
    /**
     * 统一线程处理   https://blog.csdn.net/wxd_beijing/article/details/70059615
     * <p>
     * 发布事件io线程，接收事件主线程
     */
    public static <T>ObservableTransformer<T,T>rxSchedulerHelper(){//compose处理线程
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
