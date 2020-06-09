package com.chenxuan.common.utils.matisse

import android.app.Activity
import android.content.pm.ActivityInfo
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.internal.entity.CaptureStrategy

/**
 * @author cx
 */
object ImageSelector {
    private const val REQUEST_CODE_CHOOSE = 10

    fun open() {
        AndPermission.with(ActivityUtils.getTopActivity())
            .runtime()
            .permission(
                arrayOf(
                    Permission.CAMERA,
                    Permission.READ_EXTERNAL_STORAGE,
                    Permission.WRITE_EXTERNAL_STORAGE
                )
            )
            .onGranted {
                realOpen(ActivityUtils.getTopActivity())
            }
            .onDenied {
                ToastUtils.showShort("您拒绝了权限")
            }
            .start()
    }

    private fun realOpen(activity: Activity) {
        Matisse.from(activity)
            .choose(MimeType.ofAll())
            .countable(true)
            .maxSelectable(9)
            .capture(true)
            .captureStrategy(CaptureStrategy(true, "com.chenxuan.kotlin.mvp.fileprovider"))
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
            .thumbnailScale(0.85f)
            .imageEngine(CxGlideEngine())
            .forResult(REQUEST_CODE_CHOOSE)
    }
}
