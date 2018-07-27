package com.neo.customviewpres.utils

import android.content.res.Resources

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
fun Float.toDp() = this / Resources.getSystem().displayMetrics.density
fun Float.toPx() = this * Resources.getSystem().displayMetrics.density