package com.dailin.zhihuibeijingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

/**
 * 闪屏页面
 * */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //找到布局
        RelativeLayout relativeLayout_splash = (RelativeLayout) findViewById(R.id.splash);

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);//设置时间
        rotateAnimation.setFillAfter(true);//保持动画结束状态

        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(3000);//设置时间
        scaleAnimation.setFillAfter(true);//保持结束状态

        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(5000);//设置时间
        alphaAnimation.setFillAfter(true);//保持结束状态

        //动画集合
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        //开启动画
        relativeLayout_splash.startAnimation(set);

    }
}
