package com.push.service;

import java.util.List;

public class JpushBean {
    private String cid;
    private String platform;
    private Audience audience;
    private Notification notification;
    private Options options;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public static class Audience {
        private List<String> tag;
        private List<String> alias;

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }
    }

    public static class Notification {
        private Android android;

        public Android getAndroid() {
            return android;
        }

        public void setAndroid(Android android) {
            this.android = android;
        }
    }

    public static class Android {
        private String alert;
        private String title;
        private int builder_id;
        private String large_icon;
        private int alert_type = 1;
        private ActivityIntent intent;
        private String uri_activity;
        private Extra extras;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getBuilder_id() {
            return builder_id;
        }

        public void setBuilder_id(int builder_id) {
            this.builder_id = builder_id;
        }

        public String getLarge_icon() {
            return large_icon;
        }

        public void setLarge_icon(String large_icon) {
            this.large_icon = large_icon;
        }

        public String getUri_activity() {
            return uri_activity;
        }

        public void setUri_activity(String uri_activity) {
            this.uri_activity = uri_activity;
        }

        public ActivityIntent getIntent() {
            return intent;
        }

        public void setIntent(ActivityIntent intent) {
            this.intent = intent;
        }

        public Extra getExtras() {
            return extras;
        }

        public void setExtras(Extra extras) {
            this.extras = extras;
        }
    }

    public static class ActivityIntent {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Extra {
        public String id;
        public int type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }


    public static class Options {
        private int time_to_live;
        private boolean apns_production;
        private String apns_collapse_id;
        private ThirdPartyChannel third_party_channel;

        public int getTime_to_live() {
            return time_to_live;
        }

        public void setTime_to_live(int time_to_live) {
            this.time_to_live = time_to_live;
        }

        public boolean isApns_production() {
            return apns_production;
        }

        public void setApns_production(boolean apns_production) {
            this.apns_production = apns_production;
        }

        public String getApns_collapse_id() {
            return apns_collapse_id;
        }

        public void setApns_collapse_id(String apns_collapse_id) {
            this.apns_collapse_id = apns_collapse_id;
        }

        public ThirdPartyChannel getThird_party_channel() {
            return third_party_channel;
        }

        public void setThird_party_channel(ThirdPartyChannel third_party_channel) {
            this.third_party_channel = third_party_channel;
        }
    }

    public static class ThirdPartyChannel {
        private HuaWei huawei;

        public HuaWei getHuawei() {
            return huawei;
        }

        public void setHuawei(HuaWei huawei) {
            this.huawei = huawei;
        }
    }

    public static class HuaWei {
        private String distribution;
        private String distribution_fcm;
        private String importance;
        private String large_icon;
        private String small_icon_uri;
        private boolean only_use_vendor_style = true;
        private int style;

        public String getDistribution() {
            return distribution;
        }

        public void setDistribution(String distribution) {
            this.distribution = distribution;
        }

        public String getDistribution_fcm() {
            return distribution_fcm;
        }

        public void setDistribution_fcm(String distribution_fcm) {
            this.distribution_fcm = distribution_fcm;
        }

        public String getImportance() {
            return importance;
        }

        public void setImportance(String importance) {
            this.importance = importance;
        }

        public String getLarge_icon() {
            return large_icon;
        }

        public void setLarge_icon(String large_icon) {
            this.large_icon = large_icon;
        }

        public String getSmall_icon_uri() {
            return small_icon_uri;
        }

        public void setSmall_icon_uri(String small_icon_uri) {
            this.small_icon_uri = small_icon_uri;
        }

        public boolean isOnly_use_vendor_style() {
            return only_use_vendor_style;
        }

        public void setOnly_use_vendor_style(boolean only_use_vendor_style) {
            this.only_use_vendor_style = only_use_vendor_style;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }
    }


}
