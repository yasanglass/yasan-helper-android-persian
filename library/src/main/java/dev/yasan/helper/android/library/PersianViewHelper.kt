package dev.yasan.helper.android.library

import android.app.Activity
import android.view.View

/**
 * A helper class with a set of functions that help with view related difficulties in Persian Android applications.
 */
object PersianViewHelper {

    /**
     * Sets the activity's layout direction to right-to-left
     */
    fun forceRTL(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL }

    /**
     * Sets the activity's layout direction to left-to-right
     */
    fun forceLTR(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR }

}

/**
 * Sets the activity's layout direction to right-to-left
 */
fun Activity.forceRTL() = PersianViewHelper.forceRTL(this)

/**
 * Sets the activity's layout direction to left-to-right
 */
fun Activity.forceLTR() = PersianViewHelper.forceLTR(this)