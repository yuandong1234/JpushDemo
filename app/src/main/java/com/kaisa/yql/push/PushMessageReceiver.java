package com.kaisa.yql.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

/**
 * 〈推送消息接收器〉
 *
 * @author giga_andorid_2019_05
 * @create 2021/3/4
 * @since 1.0.0
 */
public class PushMessageReceiver extends JPushMessageReceiver {
    private static final String TAG = "JPUSH";

    /**
     * 注册成功回调
     *
     * @param context
     * @param s
     */
    @Override
    public void onRegister(Context context, String s) {
        super.onRegister(context, s);
        Log.e(TAG, "onRegister");
    }

    /**
     * 长连接状态回调
     *
     * @param context
     * @param b
     */
    @Override
    public void onConnected(Context context, boolean b) {
        super.onConnected(context, b);
        Log.e(TAG, "onConnected");
    }

    /**
     * 标签操作回调
     *
     * @param context
     * @param jPushMessage
     */
    @Override
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.e(TAG, "onTagOperatorResult");
        TagAliasOperatorHelper.getInstance().onTagOperatorResult(context, jPushMessage);
        super.onTagOperatorResult(context, jPushMessage);
    }

    /**
     * 别名操作回调
     *
     * @param context
     * @param jPushMessage
     */
    @Override
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        Log.e(TAG, "onAliasOperatorResult");
        TagAliasOperatorHelper.getInstance().onAliasOperatorResult(context, jPushMessage);
        super.onAliasOperatorResult(context, jPushMessage);
    }

    /**
     * 自定义消息回调
     *
     * @param context
     * @param customMessage
     */
    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        super.onMessage(context, customMessage);
        Log.e(TAG, "onMessage");
    }

    /**
     * 收到通知回调
     *
     * @param context
     * @param notificationMessage
     */
    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageArrived(context, notificationMessage);
        Log.e(TAG, "onNotifyMessageArrived : "+notificationMessage.toString());
    }

    /**
     * 点击通知回调
     *
     * @param context
     * @param notificationMessage
     */
    @Override
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageOpened(context, notificationMessage);
        Log.e(TAG, "onNotifyMessageOpened : "+notificationMessage.toString());
    }

    @Override
    public void onMultiActionClicked(Context context, Intent intent) {
        // super.onMultiActionClicked(context, intent);
        Log.e(TAG, "onMultiActionClicked");
    }
}