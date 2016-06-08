package com.dailin.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dailin.zhihuibeijingapp.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class LeftMenuFragment extends BaseFragment {

    @Override
    public View initView() {
        View.inflate(mActivity,R.layout.fragment_left_menu,null);
        return null;
    }

    @Override
    public void initData() {

    }
}
