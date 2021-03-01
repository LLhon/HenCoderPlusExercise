package com.logcat.hencoderplusexercise.view.bitmapanddrawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.core.graphics.toColorInt
import com.logcat.hencoderplusexercise.utils.dp

private val INTERVAL = 50.dp

/**
 * 网格
 * Created by LLhon
 */
class MeshDrawable : Drawable() {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = "#F9A825".toColorInt()
        strokeWidth = 5.dp
    }

    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x <= bounds.right) {
            //竖直方向
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), mPaint)
            x += INTERVAL
        }
        var y = bounds.top.toFloat()
        while (y <= bounds.bottom) {
            //水平方向
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, mPaint)
            y += INTERVAL
        }
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return mPaint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return mPaint.colorFilter
    }

    override fun getOpacity(): Int {
        return when (mPaint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }
}