package com.dailin.base;

import android.app.Activity;
import android.view.View;

/**
 * 菜单详情页
 */
public abstract class BaseMenuDetailPager {
    public Activity mActivity;
    public View mRootView;//菜单详情页根布局

    public BaseMenuDetailPager(Activity mActivity) {
        this.mActivity = mActivity;
        mRootView = initView();
    }

    public abstract View initView();

    public abstract void initData();

}
