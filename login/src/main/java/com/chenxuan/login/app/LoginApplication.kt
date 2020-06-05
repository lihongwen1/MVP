package com.chenxuan.login.app

import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.chenxuan.login.BuildConfig
import com.chenxuan.net.Api
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @author cx
 */
open class LoginApplication : MultiDexApplication() {
    private val isDebug = BuildConfig.DEBUG

    override fun onCreate() {
        super.onCreate()

        //初始化网络
        Api.getInstance().init(this)
        //初始化logger
        Logger.addLogAdapter(AndroidLogAdapter())
        //初始化router
        initARouter()
    }

    private fun initARouter() {
        if (isDebug) {             // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()      // 打印日志
            ARouter.openDebug()    // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)// 尽可能早，推荐在Application中初始化
    }

}