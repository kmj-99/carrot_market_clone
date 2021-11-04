package com.riging_test.template.src

import android.R
import android.widget.FrameLayout

import android.view.ViewTreeObserver

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener


class AndroidBug5497Workaround {

    fun assistActivity(activity: Activity) {
        AndroidBug5497Workaround(activity)
    }

    private var mChildOfContent: View? = null
    private var usableHeightPrevious = 0
    private var frameLayoutParams: FrameLayout.LayoutParams? = null

    private fun AndroidBug5497Workaround(activity: Activity) {
        val content = activity.findViewById<View>(R.id.content) as FrameLayout
        mChildOfContent = content.getChildAt(0)
        mChildOfContent!!.getViewTreeObserver()
            .addOnGlobalLayoutListener(OnGlobalLayoutListener { possiblyResizeChildOfContent() })
        frameLayoutParams = mChildOfContent!!.getLayoutParams() as FrameLayout.LayoutParams?
    }

    private fun possiblyResizeChildOfContent() {
        val usableHeightNow = computeUsableHeight()
        if (usableHeightNow != usableHeightPrevious) {
            val usableHeightSansKeyboard: Int = mChildOfContent!!.getRootView().getHeight()
            val heightDifference = usableHeightSansKeyboard - usableHeightNow
            if (heightDifference > usableHeightSansKeyboard / 4) {
                // keyboard probably just became visible
                frameLayoutParams!!.height = usableHeightSansKeyboard - heightDifference
            } else {
                // keyboard probably just became hidden
                frameLayoutParams!!.height = usableHeightSansKeyboard
            }
            mChildOfContent!!.requestLayout()
            usableHeightPrevious = usableHeightNow
        }
    }

    private fun computeUsableHeight(): Int {
        val r = Rect()
        mChildOfContent!!.getWindowVisibleDisplayFrame(r)
        return r.bottom - r.top
    }
}