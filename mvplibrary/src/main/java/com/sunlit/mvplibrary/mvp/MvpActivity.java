package com.sunlit.mvplibrary.mvp;

import android.os.Bundle;

import com.sunlit.mvplibrary.base.BaseActivity;
import com.sunlit.mvplibrary.base.BasePresenter;
import com.sunlit.mvplibrary.base.BaseView;

/**
 * 适用与需要访问网络接口的ACTIVITY
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {

    protected  P mPresenter;

    /**
     * 创建presenter
     */
    protected abstract P createPresenter();

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        //创建
        mPresenter = createPresenter();
        //绑定View
        mPresenter.attachView((BaseView) this);
    }

    /**
     * 页面销毁时解除绑定
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }


}
