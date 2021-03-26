package com.kaisa.yql

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.jpush.android.api.JPluginPlatformInterface
import com.kaisa.yql.push.TagAliasOperatorHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var jPluginPlatformInterface: JPluginPlatformInterface? = null
    private val alias = "yuong1992"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jPluginPlatformInterface = JPluginPlatformInterface(this)
        initView()
    }

    private fun initView() {
        btn_register_id.setOnClickListener(this)
        btn_set_alias.setOnClickListener(this)
        btn_delete_alias.setOnClickListener(this)
        btn_set_tag.setOnClickListener(this)
        btn_delete_tag.setOnClickListener(this)
        btn_clear_tag.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_register_id -> {
                val rid = TagAliasOperatorHelper.getInstance().getRegisterId(this)
                Log.e("JPUSH", "rid : $rid")
            }
            R.id.btn_set_alias -> TagAliasOperatorHelper.getInstance().setAlias(this, alias)
            R.id.btn_delete_alias -> TagAliasOperatorHelper.getInstance().deleteAlias(this)
            R.id.btn_set_tag -> {
                val tags: MutableSet<String> = LinkedHashSet()
                tags.add(alias)
                TagAliasOperatorHelper.getInstance().setTag(this, tags)
            }
            R.id.btn_delete_tag -> {
                val tags: MutableSet<String> = LinkedHashSet()
                tags.add(alias)
                TagAliasOperatorHelper.getInstance().deleteTag(this, tags)
            }
            R.id.btn_clear_tag -> TagAliasOperatorHelper.getInstance().clearTag(this)
        }
    }

    override fun onStart() {
        super.onStart()
        jPluginPlatformInterface!!.onStart(this)
    }
}