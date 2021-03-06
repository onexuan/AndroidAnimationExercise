package com.engineer.imitate.widget.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created on 2019/3/7.
 * @author rookie
 */

const val TAG = "StackViewLayout"

class StackViewLayout : LinearLayout {


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        orientation = HORIZONTAL
    }


    override fun setLayoutDirection(layoutDirection: Int) {
        super.setLayoutDirection(layoutDirection)
        Log.e(TAG," layoutDirection==$layoutDirection")
    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        var step = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight
            val childTop = child.top
            var start = 0

            Log.e(TAG,"i==$i, layoutDirection==$layoutDirection")


            if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                start = child.left + (childWidth / 4) * step
            } else if (layoutDirection == View.LAYOUT_DIRECTION_LTR) {
                start = child.left - (childWidth / 4) * step
            }
            if (child.visibility == View.VISIBLE) {
                child.layout(start, childTop, start + childWidth, childTop + childHeight)
                step++
            }
        }

    }
}