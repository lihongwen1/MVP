package com.chenxuan.common.utils.common

import android.util.Log

/**
 * @author cx
 */
object LogUtils {
    private const val TAG = "chenxuan"

    fun v(msg: String) = Log.v(TAG, msg)

    fun d(msg: String) = Log.d(TAG, msg)

    fun i(msg: String) = Log.i(TAG, msg)

    fun w(msg: String) = Log.w(TAG, msg)

    fun e(msg: String) = Log.e(TAG, msg)

}