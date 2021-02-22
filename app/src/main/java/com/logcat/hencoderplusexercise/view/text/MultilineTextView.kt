package com.logcat.hencoderplusexercise.view.text

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

/**
 * 图文混排
 * Created by LLhon
 */
private val IMAGE_WIDTH = 150.dp
private val IMAGE_PADDING = 50.dp

class MultilineTextView(context: Context, attr: AttributeSet) : View(context, attr) {

    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tristique urna tincidunt maximus viverra. Maecenas commodo pellentesque dolor ultrices porttitor. Vestibulum in arcu rhoncus, maximus ligula vel, consequat sem. Maecenas a quam libero. Praesent hendrerit ex lacus, ac feugiat nibh interdum et. Vestibulum in gravida neque. Morbi maximus scelerisque odio, vel pellentesque purus ultrices quis. Praesent eu turpis et metus venenatis maximus blandit sed magna. Sed imperdiet est semper urna laoreet congue. Praesent mattis magna sed est accumsan posuere. Morbi lobortis fermentum fringilla. Fusce sed ex tempus, venenatis odio ac, tempor metus."
    private val fontMetrics = Paint.FontMetrics()
    private val bitmap = getAvatar(IMAGE_WIDTH.toInt())

    private val mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    override fun onDraw(canvas: Canvas) {
        //绘制多行文本
//        val staticLayout = StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, false)
//        staticLayout.draw(canvas)

        //绘制图片
        canvas.drawBitmap(bitmap, width - IMAGE_WIDTH, IMAGE_PADDING, mPaint)
        //文本度量
        mPaint.getFontMetrics(fontMetrics)
        //字体中最高字形的基线上方的最大距离
        var verticalOffset = -fontMetrics.top
        //返回测量的实际宽度
        val measuredWidth = floatArrayOf(0f)
        var start = 0
        var count: Int
        var maxWidth: Float
        while (start < text.length) {
            //检测文字绘制是否触碰到图片
            maxWidth = if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING
                || verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_WIDTH) {
                width.toFloat()
            } else {
                width.toFloat() - IMAGE_WIDTH
            }
            //测量文本，返回已测量的字符数
            count = mPaint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, mPaint)
            start += count
            //加上文本行间距
            verticalOffset += mPaint.fontSpacing
        }
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