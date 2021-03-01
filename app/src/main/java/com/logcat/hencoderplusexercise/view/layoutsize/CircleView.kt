package com.logcat.hencoderplusexercise.view.layoutsize

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class CircleView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val PADDING = 100.dp
    private val RADIUS = 100.dp

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //自己的期望尺寸
        val size = ((PADDING + RADIUS) * 2).toInt()
        //获取父View给出的测量要求
//        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
//        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)
//        val width = when(widthSpecMode) {
//            //精确值
//            MeasureSpec.EXACTLY -> widthSpecSize
//            //最大限制
//            MeasureSpec.AT_MOST -> if (size > widthSpecSize) widthSpecSize else size
//            //无限制
//            else -> size
//        }
//        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
//        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)
//        val height = when(heightSpecMode) {
//            MeasureSpec.EXACTLY -> heightSpecSize
//            MeasureSpec.AT_MOST -> if (size > heightSpecSize) heightSpecSize else size
//            else -> size
//        }

        //使用resolveSize()就等同于上面的代码
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, mPaint)
    }
}