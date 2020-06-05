package com.chenxuan.login.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chenxuan.bean.login.ChaptersBean
import com.chenxuan.common.base.BaseActivity
import com.chenxuan.common.utils.ktx.setSingleClick
import com.chenxuan.common.utils.router.Router
import com.chenxuan.common.utils.router.RouterPath
import com.chenxuan.login.R
import com.chenxuan.login.contract.ILogin
import com.chenxuan.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = RouterPath.LOGIN_MAIN)
class LoginActivity : BaseActivity<ILogin.View, LoginPresenter>(), ILogin.View {
    override fun initData(savedInstanceState: Bundle?) {
        presenter.getChapters()
    }

    override fun initView(savedInstanceState: Bundle?) {
        tvLogin.setSingleClick {
            Router.startActivity(RouterPath.LOGIN_SCAN)
        }
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun getContentView(): Int {
        return R.layout.activity_login
    }

    override fun onSuccess(list: List<ChaptersBean>) {
        tvLogin.text = list.toString()
    }
}
