package com.kaisa.yql;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class JpushTargetActivity extends AppCompatActivity {
    /**
     * intent:#Intent;component=com.kaisa.yql/com.kaisa.yql.JpushTargetActivity;end
     * app://yql/JpushTargetActivity/
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush_target);
    }
}