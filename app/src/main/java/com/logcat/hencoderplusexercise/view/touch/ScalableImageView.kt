package com.logcat.hencoderplusexercise.view.touch

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.OverScroller
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ScaleGestureDetectorCompat
import androidx.core.view.ViewCompat
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
class ScalableImageView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(resources, IMAGE_SIZE)
    //初始偏移量
    private var originalOffsetX = 0f
    private var originalOffsetY = 0f
    //当前偏移量
    private var offsetX = 0f
    private var offsetY = 0f
    //小图的宽高比
    private var smallScale = 0f
    //大图的宽高比
    private var bigScale = 0f
    //是否是大图
    private var isBig = false
    private val gestureListener = GestureListener()
    private val scaleGestureListener = ScaleGestureListener()
    //手势探测器
    private val gestureDetector = GestureDetectorCompat(context, gestureListener)
    private val scaleGestureDetector = ScaleGestureDetector(context, scaleGestureListener)
    //图片缩放的动画完成度
    private var currentScale = 0f
        set(value) {
            field = value
            invalidate()
        }
    //图片的缩放过程添加动画使得过渡自然
    private val animator = ObjectAnimator.ofFloat(this, "currentScale", 0f, 1f)
    //快速滑动
    private val scroller = OverScroller(context)
    private val flingRunner = FlingRunner()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        originalOffsetX = (width - IMAGE_SIZE) / 2f
        originalOffsetY = (height - IMAGE_SIZE) / 2f

        if (bitmap.width / bitmap.height.toFloat() > width / height.toFloat()) {
            //这张图片是胖图(比较宽的图)
            smallScale = width / bitmap.width.toFloat()
            bigScale = height / bitmap.height.toFloat() * EXTRA_SCALE_FRACTION
        } else {
            //这张图片是瘦图(比较细长的竖图)
            smallScale = height / bitmap.height.toFloat()
            bigScale = width / bitmap.width.toFloat() * EXTRA_SCALE_FRACTION
        }
        currentScale = smallScale
        animator.setFloatValues(smallScale, bigScale)
    }

    override fun onDraw(canvas: Canvas) {
        val scaleFraction = (currentScale - smallScale) / (bigScale - smallScale)
        //让图片跟随手指滑动而移动
        canvas.translate(offsetX * scaleFraction, offsetY * scaleFraction)
        //缩放图片
        canvas.scale(currentScale, currentScale, width / 2f, height / 2f)
        canvas.drawBitmap(bitmap, originalOffsetX, originalOffsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //代理onTouchEvent事件
        scaleGestureDetector.onTouchEvent(event)
        if (!scaleGestureDetector.isInProgress) {
            gestureDetector.onTouchEvent(event)
        }
        return true
    }

    private fun fixOffsets() {
        offsetX = min(offsetX, (bitmap.width * bigScale - width) / 2f)
        offsetX = max(offsetX, -(bitmap.width * bigScale - width) / 2f)
        offsetY = min(offsetY, (bitmap.height * bigScale - height) / 2f)
        offsetY = max(offsetY, -(bitmap.height * bigScale - height) / 2f)
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            //每次 ACTION_DOWN 事件出现的时候都会被调用，在这里返回 true 可以保证必然消费掉事件
            return true
        }

        override fun onShowPress(e: MotionEvent?) {
            //⽤户按下 100ms 不松⼿后会被调⽤，⽤于标记「可以显示按下状态了」
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            // ⽤户单击时被调⽤(⽀持⻓按时⻓按后松⼿不会调⽤、双击的第⼆下时不会被调⽤)
            return false
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            // ⽤户滑动时被调⽤
            // 第⼀个事件是⽤户按下时的 ACTION_DOWN 事件，第⼆个事件是当前事件
            // 偏移是按下时的位置 - 当前事件的位置
            if (isBig) {
                //计算手指滑动的偏移量
                offsetX -= distanceX
                offsetY -= distanceY
                //锁定边界，让大图滑动不能滑出边界
                fixOffsets()
                invalidate()
            }
            return false
        }

        override fun onLongPress(e: MotionEvent?) {
            // ⽤户⻓按（按下 500ms 不松⼿）后会被调⽤
            // 这个 500ms 在 GestureDetectorCompat 中变成了 600ms(？？？)
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            // ⽤于滑动时迅速抬起时被调⽤，⽤于⽤户希望控件进⾏惯性滑动的场景
            if (isBig) {
                //惯性滑动计算
                scroller.fling(offsetX.toInt(), offsetY.toInt(), velocityX.toInt(), velocityY.toInt(),
                    -(bitmap.width * bigScale - width).toInt() / 2,
                    (bitmap.width * bigScale - width).toInt() / 2,
                    -(bitmap.height * bigScale - height).toInt() / 2,
                    (bitmap.height * bigScale - height).toInt() / 2)
                //下一帧刷新
                ViewCompat.postOnAnimation(this@ScalableImageView, flingRunner)
            }
            return false
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            // ⽤户单击时被调⽤
            // 和 onSingltTapUp() 的区别在于，⽤户的⼀次点击不会⽴即调⽤这个⽅法，⽽是在⼀定时间后（300ms），确认⽤户没有进⾏双击，这个⽅法才会被调⽤
            return false
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            // ⽤户双击时被调⽤
            // 注意：第⼆次触摸到屏幕时就调⽤，⽽不是抬起时
            isBig = !isBig
            if (isBig) {
                //从小到大
                offsetX = (e.x - width / 2f) * (1 - bigScale / smallScale)
                offsetY = (e.y - height / 2f) * (1 - bigScale / smallScale)
                fixOffsets()
                animator.start()
            } else {
                //从大到小
                animator.reverse()
            }
            return true
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            // ⽤户双击第⼆次按下时、第⼆次按下后移动时、第⼆次按下后抬起时都会被调⽤
            // 常⽤于「双击拖拽」的场景
            return false
        }
    }

    inner class ScaleGestureListener : ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            //新的捏撑事件
            val tempCurrentScale = currentScale * detector.scaleFactor
            if (tempCurrentScale < smallScale || tempCurrentScale > bigScale) {
                return false
            } else {
                currentScale *= detector.scaleFactor // 0 1; 0 无穷
                //这个返回值表示事件是否消耗，即这个事件算不算数
                return true
            }
        }

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            //捏撑开始
            offsetX = (detector.focusX - width / 2f) * (1 - bigScale / smallScale)
            offsetY = (detector.focusY - height / 2f) * (1 - bigScale / smallScale)
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            //捏撑结束
        }

    }

    inner class FlingRunner : Runnable {

        override fun run() {
            //计算此时的位置，并且如果滑动已经结束，就停止
            if (scroller.computeScrollOffset()) {
                //把此时的位置应用于界面
                offsetX = scroller.currX.toFloat()
                offsetY = scroller.currY.toFloat()
                invalidate()
                //下一帧刷新
                ViewCompat.postOnAnimation(this@ScalableImageView, this)
            }
        }
    }
}