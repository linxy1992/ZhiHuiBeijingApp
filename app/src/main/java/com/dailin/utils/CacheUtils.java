package com.dailin.utils;


import android.content.Context;

/*
* 网络缓存工具
*/
public class CacheUtils {
    /*
    * 以url为key，以json为value，保存在本地*/

    public static void setCache(Context context,String url,String json){
        PreferenceUtils.setString(context,url,json);
    }

    public static String getCache(Context context,String key){
        return PreferenceUtils.getString(context,key,null);
    }
}
