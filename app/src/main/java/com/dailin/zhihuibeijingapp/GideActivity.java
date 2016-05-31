package com.dailin.zhihuibeijingapp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class GideActivity extends AppCompatActivity {

    //定义图片数组
    private int[] images = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    private ViewPager vp_guide;
    private ArrayList<ImageView> imagesArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gide);

        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        init();//初始化数据
        vp_guide.setAdapter(new MyPagerAdapter());
    }

    //初始化数据
    public void init(){
        imagesArrayList = new ArrayList<>();
        for(int i = 0;i<images.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);//通过设置背景，让宽高填充布局
            imagesArrayList.add(imageView);
        }

    }

    public class MyPagerAdapter extends PagerAdapter{

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
            ImageView view =  imagesArrayList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
        }
    }
}
