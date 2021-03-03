package com.logcat.hencoderplusexercise.view.layoutlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.setPadding
import com.logcat.hencoderplusexercise.utils.dp
import java.util.*

/**
 *
 * Created by LLhon
 */

private val TEXT_SIZES = intArrayOf(16, 18, 22)
private val COLORS = intArrayOf(
    Color.parseColor("#FF6E40"),
    Color.parseColor("#1E88E5"),
    Color.parseColor("#D81B60"),
    Color.parseColor("#FF8BC34A"),
    Color.parseColor("#FF6200EE"),
    Color.parseColor("#FF018786"),
    Color.parseColor("#FF4CAF50")
)
private val CORNER_RADIUS = 6.dp
private val LEFT_PADDING = 10.dp
private val TOP_PADDING = 5.dp

class ColoredTextView(context: Context, attr: AttributeSet) : AppCompatTextView(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mRandom = Random()

    init {
        setTextColor(Color.WHITE)
        textSize = TEXT_SIZES[mRandom.nextInt(3)].toFloat()
        mPaint.color = COLORS[mRandom.nextInt(COLORS.size)]
        setPadding(LEFT_PADDING.toInt(), TOP_PADDING.toInt(), LEFT_PADDING.toInt(), TOP_PADDING.toInt())
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), CORNER_RADIUS, CORNER_RADIUS, mPaint)
        super.onDraw(canvas)
    }
}