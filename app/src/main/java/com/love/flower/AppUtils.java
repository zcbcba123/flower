package com.love.flower;

import android.content.Context;
import android.os.Handler;
import android.os.Process;


public class AppUtils {
    /**
     * 获取上下文对象
     *
     * @return 上下文对象
     */
    public static Context getContext(){
        return MyApplication.getContext();
    }
    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler(){
        return MyApplication.getHandler();
    }
    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainTreadId(){return MyApplication.getMainThreadId();}

    /**
     * 判断是否运行在主线程
     *
     * @return true：当前线程运行在主线程
     * fasle：当前线程没有运行在主线程
     */
    public static boolean isRunOnUIThread(){
        // 获取当前线程id, 如果当前线程id和主线程id相同, 那么当前就是主线程
        int myTid = Process.myTid();
        if (myTid== getMainTreadId()){
            return true;
        }
        return false;
    }
    /**
     * 运行在主线程
     *
     * @param r 运行的Runnable对象
     */
    public static void runOnUIThread(Runnable r){
        if (isRunOnUIThread()){
            //已经是主线程，直接运行
            r.run();
        }else {
            // 如果是子线程, 借助handler让其运行在主线程
            getHandler().post(r);
        }
    }
}
