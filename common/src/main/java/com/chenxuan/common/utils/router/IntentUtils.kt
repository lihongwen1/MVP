package com.chenxuan.common.utils.router

import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission

object IntentUtils {
    fun gotoScanActivity() {
        AndPermission.with(ActivityUtils.getTopActivity())
            .runtime()
            .permission(Permission.CAMERA)
            .onGranted {
                Router.startActivity(RouterPath.LOGIN_SCAN)
            }
            .onDenied {
                ToastUtils.showShort("请打开摄像头权限")
            }
            .start()
    }
}