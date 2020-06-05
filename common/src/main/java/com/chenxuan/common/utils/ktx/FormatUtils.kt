package com.chenxuan.common.utils.ktx

import java.text.DecimalFormat

/**
 * @author cx
 * money 格式化
 */
fun Double.format2Money(): String {
    val pattern = "###,###.##"
    val df = DecimalFormat(pattern)
    return df.format(this)
}