package com.chenxuan.common.base

import android.app.Activity
import com.blankj.utilcode.util.ToastUtils
import com.chenxuan.common.utils.dialog.DialogUtils
import com.trello.rxlifecycle3.LifecycleTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author cx
 */
abstract class BaseFragment<V : IView, T : BasePresenter<V>> : BaseSimpleFragment(), IView {
    protected lateinit var presenter: T
    private lateinit var activity: Activity

    protected abstract fun createPresenter(): T

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.activity = activity
    }

    override fun initPresenter() {
        super.initPresenter()
        presenter = createPresenter()
        lifecycle.addObserver(presenter)
    }

    override fun showToast(msg: String) {
        ToastUtils.showShort(msg)
    }

    override fun finishPage() {

    }

    override fun <T> bindThread(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    override fun <T> bindLifeCycle(): LifecycleTransformer<T> {
        return bindToLifecycle()
    }

    override fun <T> bindLoading(): ObservableTransformer<T, T> {
        return DialogUtils.applyProgressBar<T>(activity, "请稍候...")
    }
}