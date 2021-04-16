package com.kc.kc_changeicon

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kc.kc_changeicon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var mPackageManager: PackageManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mPackageManager = applicationContext.packageManager

        binding.ivIconFesterval.setOnClickListener {
            val festervalIcon = ComponentName(baseContext, "com.kc.kc_changeicon.mainActivity")
            enableComponent(festervalIcon)
            disableComponent(componentName)
        }

        binding.ivIconNomal.setOnClickListener {
            val normalIcon = ComponentName(baseContext, "com.kc.kc_changeicon.MainActivity")
            enableComponent(normalIcon)
            disableComponent(componentName)
        }
    }

    //启用组件
    private fun enableComponent(componentName: ComponentName){
        mPackageManager?.setComponentEnabledSetting(
                componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
    }

    //隐藏组件
    private fun disableComponent(componentName: ComponentName){
        mPackageManager?.setComponentEnabledSetting(
                componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
    }
}