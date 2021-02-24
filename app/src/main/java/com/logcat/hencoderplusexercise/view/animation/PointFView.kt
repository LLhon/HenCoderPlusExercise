package com.logcat.hencoderplusexercise.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class PointFView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 20.dp
        strokeCap = Paint.Cap.ROUND
    }
    private var point = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPoint(point.x, point.y, mPaint)
    }
}