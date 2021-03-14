package com.logcat.hencoderplusexercise.view.touch

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.logcat.hencoderplusexercise.utils.dp
import com.logcat.hencoderplusexercise.utils.getAvatar
import kotlin.math.max
import kotlin.math.min

private val IMAGE_SIZE = 300.dp.toInt()
//添加一个额外的缩放系数，让图片的上下两边超出屏幕外
private const val EXTRA_SCALE_FRACTION = 1.5f

/**
 * 自定义触摸反馈之可双向滑动缩放的ImageView
 * Created by LLhon
 */
class ScalableImageView(context: Context, attrs: AttributeSet?) : View(context, attrs),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(resources, IMAGE_SIZE)
    private var offsetX = 0f
    private var offsetY = 0f
    //小图的宽高比
    private var smallScale = 0f
    //大图的宽高比
    private var bigScale = 0f
    //是否是大图
    private var isBig = false
    //手势探测器
    private val gestureDetector = GestureDetectorCompat(context, this)
    //图片缩放的动画完成度
    private var scaleFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
    //图片的缩放过程添加动画使得过渡自然
    private val animator = ObjectAnimator.ofFloat(this, "scaleFraction", 0f, 1f)
    private var moveX = 0f
    private var moveY = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        offsetX = (width - IMAGE_SIZE) / 2f
        offsetY = (height - IMAGE_SIZE) / 2f

        if (bitmap.width / bitmap.height.toFloat() > width / height.toFloat()) {
            //这张图片是胖图(比较宽的图)
            smallScale = width / bitmap.width.toFloat()
            bigScale = height / bitmap.height.toFloat() * EXTRA_SCALE_FRACTION
        } else {
            //这张图片是瘦图(比较细长的竖图)
            smallScale = height / bitmap.height.toFloat()
            bigScale = width / bitmap.width.toFloat() * EXTRA_SCALE_FRACTION
        }
    }

    override fun onDraw(canvas: Canvas) {
        //让图片跟随手指滑动而移动
        canvas.translate(moveX, moveY)
        //缩放图片
        canvas.scale(smallScale + (bigScale - smallScale) * scaleFraction,
            smallScale + (bigScale - smallScale) * scaleFraction, width / 2f, height / 2f)
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //代理onTouchEvent事件
        return gestureDetector.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(
        downEvent: MotionEvent?,
        currEvent: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        if (isBig) {
            //计算手指滑动的偏移量
            moveX -= distanceX
            Log.e("onScroll", "moveX=${moveX}, max=${(bitmap.width - width) / 2f}, " +
                    "min=${-(bitmap.width - width) / 2f}")
            // TODO: 2021/3/15 修复滑动时图片滑出边界问题 
//            moveX = min(moveX, -(bitmap.width - width) / 2f)
//            moveX = max(moveX, -(bitmap.width - width) / 2f)
            moveY -= distanceY
//            moveY = min(moveY, -(bitmap.height - height) / 2f)
//            moveY = max(moveY, (bitmap.height - height) / 2f)
            invalidate()
        }
        return false
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {

        return false
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        isBig = !isBig
        if (isBig) {
            //从小到大
            animator.start()
        } else {
            //从大到小
            animator.reverse()
        }
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return false
    }
}