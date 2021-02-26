package com.logcat.hencoderplusexercise.view.bitmapanddrawable

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class MeshDrawableView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val drawable = MeshDrawable()

    override fun onDraw(canvas: Canvas) {
        //必须要调用此方法来设置绘制范围，因为默认是0
        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
        //把 Drawable 设置的绘制内容绘制到 Canvas 中
        drawable.draw(canvas)
    }
}