package com.kaisa.yql;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kaisa.yql.push.TagAliasOperatorHelper;

import java.util.LinkedHashSet;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import cn.jpush.android.api.JPluginPlatformInterface;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private JPluginPlatformInterface jPluginPlatformInterface;
    private String alias = "yuong1992";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jPluginPlatformInterface = new JPluginPlatformInterface(this);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_register_id).setOnClickListener(this);
        findViewById(R.id.btn_set_alias).setOnClickListener(this);
        findViewById(R.id.btn_delete_alias).setOnClickListener(this);
        findViewById(R.id.btn_set_tag).setOnClickListener(this);
        findViewById(R.id.btn_delete_tag).setOnClickListener(this);
        findViewById(R.id.btn_clear_tag).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_id:
                String rid = TagAliasOperatorHelper.getInstance().getRegisterId(this);
                Log.e("JPUSH", "rid : " + rid);
                break;
            case R.id.btn_set_alias:
                TagAliasOperatorHelper.getInstance().setAlias(this, alias);
                break;
            case R.id.btn_delete_alias:
                TagAliasOperatorHelper.getInstance().deleteAlias(this);
                break;
            case R.id.btn_set_tag: {
                Set<String> tags = new LinkedHashSet<>();
                tags.add(alias);
                TagAliasOperatorHelper.getInstance().setTag(this, tags);
            }
            break;
            case R.id.btn_delete_tag: {
                Set<String> tags = new LinkedHashSet<>();
                tags.add(alias);
                TagAliasOperatorHelper.getInstance().deleteTag(this, tags);
            }
            break;
            case R.id.btn_clear_tag:
                TagAliasOperatorHelper.getInstance().clearTag(this);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        jPluginPlatformInterface.onStart(this);
    }
}
