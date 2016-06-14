package com.dailin.base.imp.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dailin.base.BaseMenuDetailPager;

/**
 * 菜单详情页-新闻
 */
public class NewsMenuDetailPager extends BaseMenuDetailPager {

    public NewsMenuDetailPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mActivity);
        textView.setText("菜单详情页-新闻");
        textView.setTextColor(Color.RED);
        textView.setTextSize(22);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {

    }
}
