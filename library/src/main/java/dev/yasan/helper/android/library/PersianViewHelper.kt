package dev.yasan.helper.android.library

import android.app.Activity
import android.view.View

/**
 * A helper class with a set of functions that help with view related difficulties in Persian Android applications.
 * @author Yasan Ghafariyan
 */
object PersianViewHelper {

    /**
     * Sets the activity's layout direction to right-to-left
     * @author Yasan Ghafariyan
     */
    fun forceRTL(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL }

    /**
     * Sets the activity's layout direction to left-to-right
     * @author Yasan Ghafariyan
     */
    fun forceLTR(activity: Activity) { activity.window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR }

    /**
     * Sets the view's layout direction to right-to-left
     * @author Yasan Ghafariyan
     */
    fun forceRTL(view: View) { view.layoutDirection = View.LAYOUT_DIRECTION_RTL }

    /**
     * Sets the view's layout direction to left-to-right
     * @author Yasan Ghafariyan
     */
    fun forceLTR(view: View) { view.layoutDirection = View.LAYOUT_DIRECTION_LTR }

}

/**
 * Sets the activity's layout direction to right-to-left
 * @author Yasan Ghafariyan
 */
fun Activity.forceRTL() = PersianViewHelper.forceRTL(this)

/**
 * Sets the activity's layout direction to left-to-right
 * @author Yasan Ghafariyan
 */
fun Activity.forceLTR() = PersianViewHelper.forceLTR(this)

/**
 * Sets the view's layout direction to right-to-left
 * @author Yasan Ghafariyan
 */
fun View.forceRTL() = PersianViewHelper.forceRTL(this)

/**
 * Sets the view's layout direction to left-to-right
 * @author Yasan Ghafariyan
 */
fun View.forceLTR() = PersianViewHelper.forceLTR(this)