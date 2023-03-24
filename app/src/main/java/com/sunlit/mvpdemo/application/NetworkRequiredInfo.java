package com.sunlit.mvpdemo.application;

import android.app.Application;

import com.sunlit.mvplibrary.network.INetworkRequiredInfo;

public class NetworkRequiredInfo implements INetworkRequiredInfo {
    /**
     * 获取App版本名
     */
    @Override
    public String getAppVersionName() {
        return null;
    }

    /**
     * 获取App版本号
     */
    @Override
    public String getAppVersionCode() {
        return null;
    }

    /**
     * 判断是否为Debug模式
     */
    @Override
    public boolean isDebug() {
        return false;
    }

    /**
     * 获取全局上下文参数
     */
    @Override
    public Application getApplicationContext() {
        return null;
    }
}
