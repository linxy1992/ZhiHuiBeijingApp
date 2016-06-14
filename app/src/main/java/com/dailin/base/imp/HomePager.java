package com.dailin.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dailin.base.BasePager;


public class HomePager extends BasePager {
    public HomePager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        return super.initView();
    }

    @Override
    public void initData() {
        Log.d("td","----------------------------------HomePager");
        TextView textView = new TextView(mActivity);
        textView.setText("首页");
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //将控件添加到布局上
        flContent.addView(textView);

        //修改标题
        tvTitle.setText("首页");

        //菜单按钮的显示
        btnMenu.setVisibility(View.GONE);
    }


}
