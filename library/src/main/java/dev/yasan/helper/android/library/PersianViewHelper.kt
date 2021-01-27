package dev.yasan.helper.android.library

import android.app.Activity
import android.view.View

object PersianViewHelper {

    fun forceRTL(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL }
    fun forceLTR(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR }

}

fun Activity.forceRTL() = PersianViewHelper.forceRTL(this)
fun Activity.forceLTR() = PersianViewHelper.forceLTR(this)