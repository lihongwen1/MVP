package com.chenxuan.login.presenter

import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BasePresenter
import com.chenxuan.common.base.IView
import com.chenxuan.login.contract.ILogin
import com.chenxuan.login.module.LoginModule
import com.chenxuan.net.DefaultObserver

class LoginPresenter(view: IView) : BasePresenter<ILogin.View>(view) {
    private val loginModule by lazy {
        LoginModule()
    }

    fun getChapters() {
        loginModule.getChapters()
            .compose(mViewRef?.get()?.bindLoading())
            .compose(mViewRef?.get()?.bindThread())
            .compose(mViewRef?.get()?.bindLifeCycle())
            .subscribe(object : DefaultObserver<List<ChaptersBean>>() {
                override fun onSuccess(response: List<ChaptersBean>) {
                    mViewRef?.get()?.onSuccess(response)
                }
            })
    }

}