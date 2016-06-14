package com.dailin.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dailin.zhihuibeijingapp.R;

/**
 * Created by Administrator on 2016/6/8.
 */
public class BasePager {

    public Activity mActivity;
    public TextView tvTitle;
    public ImageView btnMenu;
    public FrameLayout flContent;



    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
        initView();
    }

    public View initView(){
        View view = View.inflate(mActivity, R.layout.basepager, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageView) view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }

    public void initData(){

    }

}
