package com.zs.mvpsdk.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


public class MyApplication extends Application {
    public static Context context;
    public static Handler handler;
    public static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        handler=new Handler();
        mainThreadId = android.os.Process.myTid();
    }

    /**
     * 获取上下文对象
     * @return context
     */
    public static Context getContext(){
        return context;
    }

    /**
     * 获取全局handler
     * @return 全局handler
     */
    public static Handler getHandler(){
        return handler;
    }

    /**
     * 获取主线程id
     * @return 主线程id
     */
    public static int getMainThreadId(){return mainThreadId;}

}
