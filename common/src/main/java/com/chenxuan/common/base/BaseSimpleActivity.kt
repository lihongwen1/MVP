package com.chenxuan.common.base

import android.os.Bundle
import com.chenxuan.common.R
import com.gyf.immersionbar.ktx.immersionBar
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * @author cx
 */
abstract class BaseSimpleActivity : RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initPresenter()
        initImmersionBar()
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    open fun initPresenter() {

    }

    private fun initImmersionBar() {
        immersionBar {
            barColor(R.color.colorPrimary)
        }
    }

    abstract fun getContentView(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    abstract fun initView(savedInstanceState: Bundle?)
}