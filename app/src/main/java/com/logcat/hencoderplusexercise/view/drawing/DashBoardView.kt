package com.logcat.hencoderplusexercise.view.drawing

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * 仪表盘
 * Created by LLhon
 */

//自定义的开口角度
const val OPEN_ANGLE = 120f

class DashBoardView(context: Context, attr: AttributeSet?) : View(context, attr) {

    //圆的半径
    private val RADIUS = 150.dp
    //指针长度
    private val POINTER_LENGTH = 120.dp
    //刻度宽度
    private val DASH_WIDTH = 3f.dp
    //刻度长度
    private val DASH_LENGTH = 10.dp
    //自定义刻度数量
    private val DASH_COUNT = 20f
    //自定义当前指针位置
    private val MARK = 5

    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mPath = Path()
    private lateinit var mPathEffect: PathDashPathEffect

    init {
        mPaint.strokeWidth = 5f.dp
        mPaint.style = Paint.Style.STROKE
    }

    //刻度Path
    private var mDashPath = Path().apply {
        //矩形Path
        addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        mPath.reset()
        //弧形Path
        mPath.addArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
                height / 2f + RADIUS, 90 + OPEN_ANGLE / 2, 360f - OPEN_ANGLE)
        //用于测量Path
        val pathMeasure = PathMeasure(mPath, false)
        //根据Path的长度除以刻度的总数量就是刻度的间隔
        val dashInterval = (pathMeasure.length - DASH_WIDTH) / DASH_COUNT
        //绘制刻度的Path风格
        mPathEffect = PathDashPathEffect(mDashPath, dashInterval, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {

        //画弧度
        canvas.drawPath(mPath, mPaint)
        //画刻度
        mPaint.pathEffect = mPathEffect
        canvas.drawPath(mPath, mPaint)

        mPaint.pathEffect = null

        //画指针
        //利用三角函数求出指针终点位置的X轴和Y轴长度
        canvas.drawLine(width / 2f, height / 2f, width / 2f + POINTER_LENGTH * cos(markToRadians(MARK)).toFloat(),
                height / 2f + POINTER_LENGTH * sin(markToRadians(MARK)).toFloat(), mPaint)
    }

    //当前指针角度转弧度
    private fun markToRadians(mark: Int) =
            Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / DASH_COUNT * mark).toDouble())

}