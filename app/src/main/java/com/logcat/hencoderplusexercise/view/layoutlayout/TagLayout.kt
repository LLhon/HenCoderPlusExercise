package com.logcat.hencoderplusexercise.view.layoutlayout

import android.content.Context
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children

/**
 *
 * Created by LLhon
 */
class TagLayout(context: Context, attr: AttributeSet) : ViewGroup(context, attr) {

    private val mChildrenBounds = listOf(Rect())

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // TODO: 2021/3/3  
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childBounds = mChildrenBounds[index]
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
    }
}