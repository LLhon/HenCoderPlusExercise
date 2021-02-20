package com.logcat.hencoderplusexercise.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * 饼图
 * Created by LLhon
 */
class PieChartView(context: Context, attr: AttributeSet?) : View(context, attr) {

    //圆的半径
    private val RADIUS = 150.dp
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    //自定义扇形角度
    private val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)
    //自定义扇形颜色
    private val COLORS = listOf(Color.parseColor("#FF6E40"), Color.parseColor("#2979FF"),
        Color.parseColor("#AA00FF"), Color.parseColor("#00796B"))
    //扇形偏移距离
    private val OFFSET_LENGTH = 20.dp

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }

    override fun onDraw(canvas: Canvas) {
        //绘制扇形的起始角度
        var startAngle = 0f
        for ((index, angle) in ANGLES.withIndex()) {
            if (index == 0) {
                canvas.save()
                //通过偏移canvas来达到偏移扇形的效果
                canvas.translate(OFFSET_LENGTH * cos(Math.toRadians((startAngle + angle / 2f).toDouble())).toFloat(),
                        OFFSET_LENGTH * sin(Math.toRadians((startAngle + angle / 2f).toDouble())).toFloat())
            }
            mPaint.color = COLORS[index]
            //绘制扇形
            canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS,
                    height / 2f + RADIUS, startAngle, angle, true, mPaint)
            startAngle += angle
            if (index == 0) {
                canvas.restore()
            }
        }
    }
}