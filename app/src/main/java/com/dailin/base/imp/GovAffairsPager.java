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
public class GovAffairsPager extends BasePager {
    public GovAffairsPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        return super.initView();
    }

    @Override
    public void initData() {
        Log.d("td", "----------------------------------GovAffairsPager");
        TextView textView = new TextView(mActivity);
        textView.setText("政务");
        textView.setTextSize(32);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //将控件添加到布局上
        flContent.addView(textView);

        //修改标题
        tvTitle.setText("政务");
    }
}
