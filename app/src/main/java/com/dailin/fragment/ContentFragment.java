package com.dailin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

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
    public NoScrollViewPager viewPager;
    public ArrayList<BasePager> mPagers;


    //初始化布局
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_conent, null);
        viewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
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
            pager.initData();//初始化数据
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