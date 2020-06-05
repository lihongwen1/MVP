package com.chenxuan.common.utils.matisse

import android.Manifest
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.internal.entity.CaptureStrategy

object ImageSelector {
    const val REQUEST_CODE_CHOOSE = 10

    fun open() {
        val subscribe = RxPermissions(ActivityUtils.getTopActivity() as AppCompatActivity).request(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
            .subscribe { granted ->
                if (granted) {
                    realOpen(ActivityUtils.getTopActivity() as AppCompatActivity)
                } else {
                    ToastUtils.showShort("您拒绝了权限")
                }
            }
    }

    private fun realOpen(activity: AppCompatActivity) {
        Matisse.from(activity)
            .choose(MimeType.ofAll())
            .countable(true)
            .maxSelectable(9)
            .capture(true)
            .captureStrategy(CaptureStrategy(true, "com.chenxuan.kotlinmvp.fileprovider"))
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
            .thumbnailScale(0.85f)
            .imageEngine(CxGlideEngine())
            .forResult(REQUEST_CODE_CHOOSE)
    }
}
