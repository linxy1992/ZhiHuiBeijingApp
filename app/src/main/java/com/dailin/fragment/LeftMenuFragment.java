package com.dailin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dailin.base.imp.NewsPager;
import com.dailin.zhihuibeijingapp.MainActivity;
import com.dailin.zhihuibeijingapp.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;


public class LeftMenuFragment extends BaseFragment {

    public static ArrayList mNewsMenuData;//侧边栏数据
    //@ViewInject(R.id.lv_list)//注解
    private ListView listView;
    private int mPosition;
    private LeftMenuAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        listView = (ListView) view.findViewById(R.id.lv_list);
        // ViewUtils.inject(this, view); //使用注解与注入加载布局
        return view;
    }

    @Override
    public void initData() {

    }

    //给侧边栏设置数据
    public void setData() {
        mNewsMenuData = new ArrayList();
        mNewsMenuData.add("新闻");
        mNewsMenuData.add("专题");
        mNewsMenuData.add("组图");
        mNewsMenuData.add("互动");

        adapter = new LeftMenuAdapter();
        listView.setAdapter(adapter);

        //设置监听修改内容
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPosition = position;
                adapter.notifyDataSetChanged();
                //调用修改NewsPager内的内容
                setCurrentDetailPager(position);
            }
        });

    }

    //修改NewsPager内的内容
    public void setCurrentDetailPager(int position) {
        MainActivity mainActivity = (MainActivity) mActivity;
        ContentFragment contentFragment = mainActivity.getContentFragment();
        NewsPager newsPager = contentFragment.getNewsPager();//通过contentFragment获取到NewsPager
        newsPager.setCurrentDetailPager(position);
    }

    class LeftMenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mNewsMenuData.size();
        }

        @Override
        public Object getItem(int position) {
            return mNewsMenuData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(mActivity, R.layout.left_menu_list, null);
            TextView textView = (TextView) view.findViewById(R.id.tv_menu);
            String content = (String) mNewsMenuData.get(position);
            textView.setText(content);
            //根据是否选中改变颜色
            if (mPosition == position) {
                textView.setEnabled(true);//被选中，文字变为红色
            } else {
                textView.setEnabled(false);//未被选中，文字为白色
            }
            return view;
        }
    }
}
