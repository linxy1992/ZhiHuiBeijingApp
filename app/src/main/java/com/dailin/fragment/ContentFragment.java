package com.dailin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.dailin.base.BasePager;
import com.dailin.base.imp.GovAffairsPager;
import com.dailin.base.imp.HomePager;
import com.dailin.base.imp.NewsPager;
import com.dailin.base.imp.SettingPager;
import com.dailin.base.imp.SmartServicePager;
import com.dailin.view.NoScrollViewPager;
import com.dailin.zhihuibeijingapp.R;

import java.util.ArrayList;

public class ContentFragment extends BaseFragment {
    private NoScrollViewPager viewPager;
    private ArrayList<BasePager> mPagers;
    private RadioGroup radioGroup;


    //初始化布局
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_conent, null);
        viewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_radioGroup);
        return view;
    }

    //初始化数据
    @Override
    public void initData() {
        mPagers = new ArrayList<>();
        //添加五个标签页
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsPager(mActivity));
        mPagers.add(new GovAffairsPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new SettingPager(mActivity));

        viewPager.setAdapter(new ContentPager());

        //实现点击按钮切换界面
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.btn_home:
                        viewPager.setCurrentItem(0,false);//false代表页面不具有平滑移动的效果
                        break;
                    case R.id.btn_news:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.btn_gov:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.btn_smart:
                        viewPager.setCurrentItem(3,false);
                        break;
                    case R.id.btn_setting:
                        viewPager.setCurrentItem(4,false);
                        break;
                }
            }
        });

        //因为ViewPager的状态就是点击此按钮的时候会自动加载下一个页面的内容，但是这样会浪费性能和流量，
        //所以给ViewPager设置一个监听，当点击的时候加载页面
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BasePager pager = mPagers.get(position);
                pager.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class ContentPager extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化了5个标签界面
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.initView();
            //pager.initData();//初始化数据
            //在这调用会浪费性能！！！！！！！！
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

 /*   父类有的方法
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        //return initView()
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/


}