package com.logcat.hencoderplusexercise.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.px

/**
 * 仪表盘
 * Created by LLhon
 */
class DashBoardView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(width - 150f.px, height - 150f.px, width + 150f.px,
            height + 150f.px, 120f, 180f, false, mPaint)
    }
}