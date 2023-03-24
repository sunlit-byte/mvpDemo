package com.sunlit.mvplibrary;

import android.app.Application;
import android.content.Context;

/**
 * 活动页基类
 */
public class BaseApplication extends Application {

    /**
     * 活动页管理类
     */
    private static ActivityManager activityManager;

    /**
     *
     */
    private static BaseApplication application;

    /**
     * 上下文
     */
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化管理类
        activityManager = new ActivityManager();
        //获取上下文
        context = getApplicationContext();
        //获取自身对象
        application = this;
    }

    public static ActivityManager getActivityManager() {
        return activityManager;
    }

    public static BaseApplication getApplication() {
        return application;
    }

    public static Context getContext() {
        return context;
    }
}
