package com.logcat.hencoderplusexercise.view.animation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.REVERSE
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.animation.addListener
import com.logcat.hencoderplusexercise.utils.dp

private val LINE_WIDTH = 3.dp
private val CAP_SIZE = 2.dp

/**
 * Des:
 * Date: 2021/3/25 22:34
 * Created by LLhon
 */
class LivingMaskView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    //中间线条的基础长度
    private var startCenterLineLength = 0f
    //左边线条的基础长度
    private var startLeftLineLength = 0f
    //右边线条的基础长度
    private var startRightLineLength = 0f
    //中间线条的动态长度
    var centerLineFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
    //左右两边线条的动态长度
    var leftLineFraction = 0f
        set(value) {
            field = value
        }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FF6E40")
        strokeCap = Paint.Cap.ROUND
        strokeWidth = LINE_WIDTH
        //渐变着色器
        shader = LinearGradient(0f, 0f, 0f, 20.dp, Color.parseColor("#ff7906"),
        Color.parseColor("#ff2C52"), Shader.TileMode.CLAMP)
    }

    private val centerAnimator by lazy {
        ObjectAnimator.ofFloat(this, "centerLineFraction", 0f, 1f)

    }

    private val leftAnimator by lazy {
        ObjectAnimator.ofFloat(this, "leftLineFraction", 1f, 0f)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = 17.dp
        //修正尺寸
        val width = resolveSize(size.toInt(), widthMeasureSpec)
        val height = resolveSize(size.toInt(), heightMeasureSpec)
        //保存自己的尺寸
        setMeasuredDimension(width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        startCenterLineLength = height / 5f
        startLeftLineLength = height * 2 / 5f
        startRightLineLength = height * 3 / 5f
    }

    override fun onDraw(canvas: Canvas) {
        //绘制中间线条
        canvas.drawLine(width / 2f, height.toFloat(), width / 2f,
            height - (startCenterLineLength + (height - startCenterLineLength) * centerLineFraction) + CAP_SIZE, paint)
        //绘制左边线条
        canvas.drawLine(LINE_WIDTH / 2, height.toFloat(), LINE_WIDTH / 2,
            height - (startLeftLineLength + (height - startLeftLineLength * 2) * leftLineFraction), paint)
        //绘制右边线条
        canvas.drawLine(width - LINE_WIDTH / 2, height.toFloat(), width - LINE_WIDTH / 2,
            height - (startRightLineLength + (height - startRightLineLength * 2) * leftLineFraction), paint)
    }

    fun startAnimate() {
        centerAnimator.duration = 400
        centerAnimator.interpolator = LinearInterpolator()
        centerAnimator.repeatCount = ValueAnimator.DURATION_INFINITE.toInt()
        centerAnimator.repeatMode = REVERSE
        centerAnimator.start()

        leftAnimator.duration = 400
        leftAnimator.interpolator = LinearInterpolator()
        leftAnimator.repeatCount = ValueAnimator.DURATION_INFINITE.toInt()
        leftAnimator.repeatMode = REVERSE
        leftAnimator.start()
    }

    fun stopAnimate() {
        centerAnimator.cancel()
        leftAnimator.cancel()
    }
}