package com.dailin.zhihuibeijingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dailin.utils.PreferenceUtils;

/**
 * 闪屏页面
 * */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //找到布局
        //RelativeLayout relativeLayout_splash = (RelativeLayout) findViewById(R.id.splash);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);//设置时间
        rotateAnimation.setFillAfter(true);//保持动画结束状态

        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);//设置时间
        scaleAnimation.setFillAfter(true);//保持结束状态

        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(3000);//设置时间
        alphaAnimation.setFillAfter(true);//保持结束状态

        //动画集合
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        //开启动画
        imageView.startAnimation(set);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束，跳转页面
                boolean isFirstEnter = PreferenceUtils.getBoolean(SplashActivity.this,"is_First_Enter",true);
                Intent intent;
                //第一次进入，跳转到新手引导
                if(isFirstEnter){
                    intent = new Intent(SplashActivity.this,GuideActivity.class);
                }else {//否则调到主页面
                    intent = new Intent(SplashActivity.this,MainActivity.class);
                }
                //开启activity
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
