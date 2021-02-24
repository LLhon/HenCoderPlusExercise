package com.logcat.hencoderplusexercise.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class CircleView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FF6200EE")
    }
    private var radius = 30.dp
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width / 2f, height / 2f, radius, mPaint)
    }
}