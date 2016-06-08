package com.dailin.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dailin.base.BasePager;

/**
 * Created by Administrator on 2016/6/8.
 */
public class NewsPager extends BasePager {
    public NewsPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        return super.initView();
    }

    @Override
    public void initData() {
        TextView textView = new TextView(mActivity);
        textView.setText("新闻");
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //将控件添加到布局上
        flContent.addView(textView);

        //修改标题
        tvTitle.setText("新闻");
    }
}
