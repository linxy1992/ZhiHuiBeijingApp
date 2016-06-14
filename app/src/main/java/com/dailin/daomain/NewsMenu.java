package com.dailin.daomain;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/10.
 */
public class NewsMenu {

    public int retcode;
    public ArrayList extend;
    public ArrayList<NewsMenuData> data;

    //侧边栏对象
    public class NewsMenuData{
        public int id;
        public String title;
        public int type;
        public ArrayList<NewsTabData> children;

        @Override
        public String toString() {
            return "NewsMenuData[title="+title+" ]";
        }
    }

    //页签对象
    public class NewsTabData{
        public int id;
        public String title;
        public int type;

        @Override
        public String toString() {
            return "NewsTabData[data="+data+"]";
        }
    }
}
