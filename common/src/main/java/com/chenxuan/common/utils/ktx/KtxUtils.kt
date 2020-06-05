package com.chenxuan.common.utils.ktx

import android.util.Log

/**
 * @author cx
 */
inline fun <reified T> T.ktxLog(msg: String) = Log.d(T::class.java.name, msg)

inline fun <reified T> T.ktxClass() = T::class.java

inline fun <reified T> T.ktxClassName() = T::class.java.name

inline fun <reified T> T.ktxClassField(field: String) = T::class.java.getDeclaredField(field)
