package com.push.service;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 模拟极光推送服务器向客户端推送通知
 * 操作步骤：（可以使用Postman进行调试）
 * 1. 调用https://api.jpush.cn/v3/push/cid，获取cid
 * 2. 使用（1）获取的cid,调用https://api.jpush.cn/v3/push进行推送
 */

public class JpushHelper {
    private static final String TAG = JpushHelper.class.getSimpleName();
    private String appKey = "7d3633afe15a1844c8952841";
    private String masterSecret = "815ba18c9450a96ca71100c2";
    private String pushUrl = "https://api.jpush.cn/v3/push";
    private String alias = "yuong1992";
    private Gson gson = new Gson();
    private String charset = "UTF-8";


    public void push() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                request();
            }
        }).start();
    }

    private void request() {
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;

        try {
            URL url = new URL(pushUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", getAuthorization());
            os = connection.getOutputStream();
            os.write(generatePushJson().getBytes(charset));
            os.flush();

            int responseCode = connection.getResponseCode();
            Log.e(TAG, "responseCode : " + responseCode);
            if (responseCode == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, charset));

                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\r\n");
                }
                result = sb.toString();
            }
            Log.e(TAG, "result : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }

                if (null != is) {
                    is.close();
                }

                if (null != os) {
                    os.close();
                }

                if (null != connection) {
                    connection.disconnect();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String generatePushJson() {
        JpushBean jpushBean = new JpushBean();
        jpushBean.setCid(getCid());
        jpushBean.setPlatform("all");

        JpushBean.Audience audience = new JpushBean.Audience();
        List<String> aliasList = new ArrayList<>();
        aliasList.add(alias);
        audience.setAlias(aliasList);
        jpushBean.setAudience(audience);


        JpushBean.Notification notification = new JpushBean.Notification();
        JpushBean.Android android = new JpushBean.Android();
        android.setAlert("订单提醒");
        android.setTitle("您有新的订单需要处理" + new Random().nextInt());
        android.setBuilder_id(new Random().nextInt(1000));
        android.setUri_activity("com.kaisa.yql.JpushTargetActivity");
        JpushBean.ActivityIntent intent = new JpushBean.ActivityIntent();
        intent.setUrl("intent:#Intent;component=com.kaisa.yql/com.kaisa.yql.JpushTargetActivity;end");
        android.setIntent(intent);
        JpushBean.Extra extras = new JpushBean.Extra();
        extras.setId("10086");
        extras.setType(1);
        android.setExtras(extras);
        notification.setAndroid(android);
        jpushBean.setNotification(notification);


        JpushBean.Options options = new JpushBean.Options();
        options.setTime_to_live(86400);
        options.setApns_production(true);
        options.setApns_collapse_id(String.valueOf(System.currentTimeMillis()));
        JpushBean.ThirdPartyChannel thirdPartyChannel = new JpushBean.ThirdPartyChannel();
        JpushBean.HuaWei huaWei = new JpushBean.HuaWei();
        huaWei.setDistribution("secondary_push");
        huaWei.setDistribution_fcm("secondary_pns_push");
        huaWei.setImportance("HIGH");
        thirdPartyChannel.setHuawei(huaWei);
        options.setThird_party_channel(thirdPartyChannel);
        jpushBean.setOptions(options);

        String json = gson.toJson(jpushBean);
        Log.e(TAG, "json : " + json);
        return json;
    }


    private String getCid() {
        return appKey + "-" + UUID.randomUUID().toString();
    }

    private String getAuthorization() {
        String jpushSecret = appKey + ":" + masterSecret;
        String base64Str = Base64.encodeToString(jpushSecret.getBytes(), Base64.DEFAULT);
        String authorization = "Basic " + base64Str;
        Log.e(TAG, "authorization : " + authorization);
        return authorization;
    }
}
