package com.dailin.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.dailin.base.BasePager;

/**
 * Created by Administrator on 2016/6/8.
 */
public class SettingPager extends BasePager {
    public SettingPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        return super.initView();
    }

    @Override
    public void initData() {
        Log.d("td", "----------------------------------SettingPager");
        TextView textView = new TextView(mActivity);
        textView.setText("设置");
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //将控件添加到布局上
        flContent.addView(textView);
        //修改标题
        tvTitle.setText("设置");
        //菜单按钮的显示
        btnMenu.setVisibility(View.GONE);
        
    }
}
