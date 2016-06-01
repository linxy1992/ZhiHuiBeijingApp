package com.dailin.zhihuibeijingapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    //定义图片数组
    private int[] images = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

    private ArrayList<ImageView> imagesArrayList;
    private ViewPager vp_guide;
    private LinearLayout ll_container;
    private ImageView iv_red_point;
    private int mPointDis;//红点移动的距离
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gide);

        //找到viewpager对象
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        //找到放置圆点的控件
        ll_container = (LinearLayout) findViewById(R.id.ll_container);
        //找到红点的控件
        iv_red_point = (ImageView) findViewById(R.id.iv_red_point);
        //找到按钮控件
        btn = (Button) findViewById(R.id.btn_start);

        init();//初始化数据
        vp_guide.setAdapter(new MyPagerAdapter());

        //设置监听用来判断页面是否变化
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滑动的过程中回调
                Log.d("提示信息：", "当前位置" + position + "，移动的百分比：" + positionOffset);
                //更新小红点的距离
                //计算小红点的左边距
                int leftMargin = (int) ((mPointDis * positionOffset) + position * mPointDis);
                //修改布局参数
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
                //修改布局参数
                params.leftMargin = leftMargin;
                //重新设置布局参数
                iv_red_point.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                //某个页面被选中
                if(position == imagesArrayList.size()-1){
                    btn.setVisibility(View.VISIBLE);
                }else{
                    btn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //页面状态发生变化
            }
        });

        //视图树
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //移除监听，避免重复回调
                iv_red_point.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                //layout方法执行结束的回调
                mPointDis = ll_container.getChildAt(1).getLeft() - ll_container.getChildAt(0).getLeft();
            }
        });

        //按钮监听事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调到主页面
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //初始化数据
    public void init() {
        imagesArrayList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);//通过设置背景，让宽高填充布局
            imagesArrayList.add(imageView);


            //初始化小圆点
            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.shape_gray);//设置图片
            //初始化布局参数，父控件是谁就用谁声明布局
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                //从第二个圆点开始设置左边距
                params.leftMargin = 10;
            }
            //设置布局参数
            point.setLayoutParams(params);
            //给容器添加圆点
            ll_container.addView(point);


        }

    }

    public class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imagesArrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化布局
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = imagesArrayList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
