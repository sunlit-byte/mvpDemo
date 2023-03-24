package com.sunlit.mvplibrary.base;

import android.content.Context;
import android.os.Bundle;

/**
 * 回调接口
 */
public interface UiCallback {

    /**
     * 1.初始化回调
     * 2.初始化视图
     * 3. 获取布局id
     */
    void initBeforeView(Bundle savedInstanceState);

    //初始化视图
    void initData(Bundle savedInstanceState);

    //获取布局Id
    int getLayoutId();

    void initData(Context context);
}
