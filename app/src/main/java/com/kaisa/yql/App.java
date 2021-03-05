package com.kaisa.yql;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * 〈〉
 *
 * @author giga_andorid_2019_05
 * @create 2021/3/4
 * @since 1.0.0
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true); //设置开启日志,发布时请关闭日志
        JPushInterface.init(this); // 初始化 JPush
    }
}