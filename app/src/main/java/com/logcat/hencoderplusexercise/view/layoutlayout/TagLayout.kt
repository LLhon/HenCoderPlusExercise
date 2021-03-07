package com.logcat.hencoderplusexercise.view.layoutlayout

import android.content.Context
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 *
 * Created by LLhon
 */
class TagLayout(context: Context, attr: AttributeSet) : ViewGroup(context, attr) {

    private val mChildrenBounds = mutableListOf(Rect())

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //已使用的宽度
        var widthUsed = 0
        //已使用的高度
        var heightUsed = 0
        //当前行已使用的宽度
        var lineWidthUsed = 0
        //当前行最大高度
        var lineMaxHeight = 0
        //获取父View给出的宽度测量模式
        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        //获取父View给出的宽度测量大小
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
            //给出父View的测量参考和已使用的宽度，已使用的高度，让子View自我测量
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            //当前行已使用的宽度加上当前这个子View的宽度已经超过了父View给出的宽度测量大小，说明这个子View在这行已经放不下了，需要换行布局了
            if (specWidthMode != MeasureSpec.UNSPECIFIED && lineWidthUsed + child.measuredWidth > specWidthSize) {
                //当前行已使用的宽度重置为0
                lineWidthUsed = 0
                //添加上这行的最大高度
                heightUsed += lineMaxHeight
                //当前行的最大高度重置为0
                lineMaxHeight = 0
                //让这个子View重新测量一遍
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            }

            if (index >= mChildrenBounds.size) {
                mChildrenBounds.add(Rect())
            }

            val childBounds = mChildrenBounds[index]
            //存储每个子View的布局位置左上右下
            childBounds.set(lineWidthUsed, heightUsed, lineWidthUsed + child.measuredWidth,
                heightUsed + child.measuredHeight)

            //当前行已使用的宽度加上当前子View的测量宽度
            lineWidthUsed += child.measuredWidth
            widthUsed += max(widthUsed, lineWidthUsed)
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }
        //TagLayout自己的宽度
        val selfWidth = widthUsed
        //自己的高度
        val selfHeight = heightUsed + lineMaxHeight
        //保存自己的尺寸，以提供给父View布局使用
        setMeasuredDimension(selfWidth, selfHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childBounds = mChildrenBounds[index]
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}