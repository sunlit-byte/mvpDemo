package com.sunlit.mvplibrary.base;


import java.lang.ref.WeakReference;

/**
 * presenter 基类 操作view
 * @param <V>
 */
public class BasePresenter <V extends BaseView>{

    protected WeakReference<V> weakReference;
    private V mView;

    /**
     * 绑定view
     */
    public void attachView(V view){
        mView = view;
        weakReference = new WeakReference<>(view);
    }

    /**
     * 解绑
     */
    public void detachView(){
        mView = null;
        if(weakReference != null){
            weakReference.clear();
            weakReference = null;
        }
    }
    /**
     * 获取view
     */
    public V getView(){
        if(weakReference != null){
            return weakReference.get();
        }
        return  null;
    }

    /**
     * 检查是否绑定
     */
    public boolean isViewAttached(){
        return mView != null;
    }

}
