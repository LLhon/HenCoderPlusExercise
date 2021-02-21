package com.logcat.hencoderplusexercise.view.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

/**
 * 圆形头像View
 * Created by LLhon
 */

private val AVATAR_WIDTH = 200.dp
private val AVATAR_PADDING = 20.dp
private val BORDER_WIDTH = 5.dp
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class AvatarView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    //矩形区域
    private val mBounds = RectF(AVATAR_PADDING, AVATAR_PADDING, AVATAR_PADDING + AVATAR_WIDTH,
        AVATAR_PADDING + AVATAR_WIDTH)

    override fun onDraw(canvas: Canvas) {
        //离屏缓冲，提取出一个单独空间进行绘制
        val saveCount = canvas.saveLayer(mBounds, null)
        //绘制圆
        canvas.drawOval(mBounds, mPaint)
        //设置xfermode模式
        mPaint.xfermode = XFERMODE
        //绘制图片
        canvas.drawBitmap(getAvatar(AVATAR_WIDTH.toInt()), AVATAR_PADDING, AVATAR_PADDING, mPaint)
        mPaint.xfermode = null
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = BORDER_WIDTH
        mPaint.color = Color.parseColor("#000000")
        //绘制头像的外边框
        canvas.drawOval(AVATAR_PADDING + BORDER_WIDTH / 2, AVATAR_PADDING + BORDER_WIDTH / 2,
            AVATAR_WIDTH + AVATAR_PADDING - BORDER_WIDTH / 2,
            AVATAR_WIDTH + AVATAR_PADDING - BORDER_WIDTH / 2, mPaint)
        //把单独提取的绘制空间贴回屏幕上
        canvas.restoreToCount(saveCount)
    }

    private fun getAvatar(width: Int) : Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}