package com.logcat.hencoderplusexercise.view.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class SportView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val CIRCLE_RADIUS = 120.dp
    private val CIRCLE_WIDTH = 20.dp
    private val mBounds = Rect()
    private val mFontMetrics = Paint.FontMetrics()

    private val mCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = CIRCLE_WIDTH
        strokeCap = Paint.Cap.ROUND
    }

    private val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 50.dp
        color = Color.parseColor("#EC407A")
        textAlign = Paint.Align.CENTER
        typeface = ResourcesCompat.getFont(context, R.font.font)
    }

    override fun onDraw(canvas: Canvas) {
        //绘制圆环背景
        mCirclePaint.color = Color.parseColor("#90A4AE")
        canvas.drawCircle(width / 2f, height / 2f, CIRCLE_RADIUS, mCirclePaint)
        //绘制圆环高亮进度条
        mCirclePaint.color = Color.parseColor("#EC407A")
        canvas.drawArc(width / 2f - CIRCLE_RADIUS, height / 2f - CIRCLE_RADIUS, width / 2f + CIRCLE_RADIUS,
            height / 2f + CIRCLE_RADIUS, -90f, 220f, false, mCirclePaint)

        //绘制文字
        //getTextBounds 适用于静态文字
//        mTextPaint.getTextBounds("abab", 0, "abab".length, mBounds)
//        canvas.drawText("abab", width / 2f, height / 2f - (mBounds.top + mBounds.bottom) / 2, mTextPaint)
        //getFontMetrics 可用于动态文字
        mTextPaint.getFontMetrics(mFontMetrics)
        canvas.drawText("abab", width / 2f, height / 2f - (mFontMetrics.ascent + mFontMetrics.descent) / 2, mTextPaint)
    }
}