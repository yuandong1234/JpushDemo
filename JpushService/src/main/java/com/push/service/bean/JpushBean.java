package com.push.service.bean;

import java.util.List;

/**
 * 〈推送数据结构实体〉
 *
 * @author giga_andorid_2019_05
 * @create 2021/3/26
 * @since 1.0.0
 */
public class JpushBean {
    private String platform;
    private Audience audience;
    private Notification notification;


    /**
     * 推送目标
     */
    public static class Audience {
        private List<String> tag;
        private List<String> alias;
    }

    /**
     * 通知
     */
    public static class Notification {
        private Android android;
    }

    /**
     * 通知-android
     */
    public static class Android {
        private String alert;
        private String title;
        private int builder_id = 1;
        private int alert_type = -1;
        private int style = 1;
    }

    public static class Options {

    }
}