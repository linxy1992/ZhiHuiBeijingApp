package com.dailin.base.imp;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.dailin.base.BaseMenuDetailPager;
import com.dailin.base.BasePager;
import com.dailin.base.imp.menu.InterMenuDetailPager;
import com.dailin.base.imp.menu.NewsMenuDetailPager;
import com.dailin.base.imp.menu.PhotoMenuPager;
import com.dailin.base.imp.menu.TopicMenuDetailPager;
import com.dailin.daomain.NewsMenu;
import com.dailin.fragment.LeftMenuFragment;
import com.dailin.global.GlobalConstants;
import com.dailin.utils.CacheUtils;
import com.dailin.zhihuibeijingapp.MainActivity;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

public class NewsPager extends BasePager {

    public ArrayList mMenuDetailPagers;//详情页集合
    private LeftMenuFragment leftMenuFragment;

    public NewsPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        return super.initView();
    }

    @Override
    public void initData() {
        Log.d("td", "----------------------------------NewsPager");
        //修改标题
        tvTitle.setText("新闻");
        //菜单按钮的显示
        btnMenu.setVisibility(View.VISIBLE);

        /*
        //先判断有没有缓存，如果有的话就加载缓存
        String cache = CacheUtils.getCache(mActivity,GlobalConstants.CATEGORY_URL);
        if(!TextUtils.isEmpty(cache)){
            Log.d("ts","-------------------------------发现缓存");
            processData(cache);
        }else{
            //请求服务器，获取数据，使用开源框架XUtils
            getDataFormServer();
        }*/

        //加载侧边栏内容
        loadLeftFragment();
        //加载布局
        loadView();

    }

    //加载布局
    public void loadView(){
        mMenuDetailPagers = new ArrayList();
        mMenuDetailPagers.add(new NewsMenuDetailPager(mActivity));
        mMenuDetailPagers.add(new TopicMenuDetailPager(mActivity));
        mMenuDetailPagers.add(new PhotoMenuPager(mActivity));
        mMenuDetailPagers.add(new InterMenuDetailPager(mActivity));
        //显示新闻详情页
        setCurrentDetailPager(0);
    }

    //加载侧边栏布局
    public void loadLeftFragment() {
        MainActivity main = (MainActivity) mActivity;
        leftMenuFragment = main.getLeftMenuFragment();
        leftMenuFragment.setData();
    }

    //设置菜单详情页
    public void setCurrentDetailPager(int position) {
        //获取当前页面
        BaseMenuDetailPager pager = (BaseMenuDetailPager)mMenuDetailPagers.get(position);
        View view = pager.mRootView;
        //清空之前的布局
        flContent.removeAllViews();
        //将布局加载到页面
        flContent.addView(view);
        //初始化页面数据
        pager.initData();
        //获取详情页标题
        String mTitle = (String) leftMenuFragment.mNewsMenuData.get(position);
        Log.d("biaoti", "+++++++++++++++++++++++++++ " + mTitle);
        //修改标题
        tvTitle.setText(mTitle);
    }

    //请求服务器
    private void getDataFormServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, GlobalConstants.CATEGORY_URL,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;
                        Log.d("ts", "==========================服务器返回结果：" + result);
                        //jsonObject
                        processData(result);
                        //写缓存
                        CacheUtils.setCache(mActivity, GlobalConstants.CATEGORY_URL, result);
                    }
                    @Override
                    public void onFailure(HttpException e, String s) {
                        e.printStackTrace();
                        Log.d("ts", "==========================失败");
                    }
                });
    }

    //解析数据
    public void processData(String json) {
        //Google :Gson
        Gson gson = new Gson();
        NewsMenu data = gson.fromJson(json, NewsMenu.class);
        Log.d("ts", "===============================解析结果：" + data);
    }


}
