package com.logcat.hencoderplusexercise.view.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp

/**
 * 演示 Xfermode 效果
 * Created by LLhon
 */

private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class XfermodeView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBounds = RectF(150f.dp, 50f.dp, 300f.dp, 200f.dp)
    private val mCircleBitmap = Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)
    private val mSquareBitmap = Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(mCircleBitmap)
        mPaint.color = Color.parseColor("#D81B60")
        //绘制圆，需要带上透明矩形区域
        canvas.drawOval(50.dp, 0.dp, 150.dp, 100.dp, mPaint)
        canvas.setBitmap(mSquareBitmap)
        mPaint.color = Color.parseColor("#1E88E5")
        //绘制矩形，需要带上透明矩形区域
        canvas.drawRect(0.dp, 50.dp, 100.dp, 150.dp, mPaint)
    }

    override fun onDraw(canvas: Canvas) {
        //离屏缓冲
        val saveCount = canvas.saveLayer(mBounds, null)
        canvas.drawBitmap(mCircleBitmap, 150.dp, 50.dp, mPaint)
        mPaint.xfermode = XFERMODE
        canvas.drawBitmap(mSquareBitmap, 150.dp, 50.dp, mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(saveCount)
    }
}