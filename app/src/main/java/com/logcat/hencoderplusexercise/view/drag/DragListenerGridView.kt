package com.logcat.hencoderplusexercise.view.drag

import android.content.Context
import android.graphics.drawable.Drawable
import android.icu.util.Measure
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children

private val COLUMN = 2
private val ROW = 3

/**
 * Des:
 * Date: 2021/3/21 23:24
 * Created by LLhon
 */
class DragListenerGridView(context: Context, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    private val dragListener = MyDragListener()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val specHeightSize = MeasureSpec.getSize(heightMeasureSpec)
        val childWidth = specWidthSize / COLUMN
        val childHeight = specHeightSize / ROW
        val childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY)
        val childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY)
        //根据给出的测量参考让子View自我测量
        measureChildren(childWidthMeasureSpec, childHeightMeasureSpec)
        //保存自己的尺寸
        setMeasuredDimension(specWidthSize, specHeightSize)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val childWidth = width / COLUMN
        val childHeight = height / ROW
        var childLeft: Int
        var childTop: Int
        for ((index, child) in children.withIndex()) {
            childLeft = (index % 2) * childWidth
            childTop = (index / 2) * childHeight
            //布局每一个子View
            child.layout(0, 0, childWidth, childHeight)
            child.translationX = childLeft.toFloat()
            child.translationY = childTop.toFloat()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        for ((index, child) in children.withIndex()) {
            child.setOnLongClickListener { v ->
                child.startDrag(null, DragShadowBuilder(v), v, 0)
                false
            }
            child.setOnDragListener(dragListener)
        }
    }

    private inner class MyDragListener : OnDragListener {

        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> if (event.localState === v) {
                    //拖拽开始时，隐藏当前拖拽位置的View
                    v.visibility = INVISIBLE
                }
                DragEvent.ACTION_DRAG_ENTERED -> if (event.localState !== v) {
                    //拖拽中，除开当前拖拽的View，对它们进行重排序
                    sort(v)
                }
                DragEvent.ACTION_DRAG_ENDED -> if (event.localState === v) {
                    //拖拽结束后，恢复显示当前拖拽位置的View
                    v.visibility = VISIBLE
                }
            }
            return true
        }

    }

    private fun sort(targetView: View) {
        // TODO: 2021/3/22
    }
}