package com.logcat.hencoderplusexercise.view.edittext

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.setPadding
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

//悬浮文字大小
private val TEXT_SIZE = 12.dp
//悬浮文字的间距
private val TEXT_MARGIN = 6.dp
//悬浮文字所在位置的横向偏移量
private val HORIZONTAL_OFFSET = 5.dp
//悬浮文字所在位置的纵向偏移量
private val VERTICAL_OFFSET = 18.dp
//悬浮文字上下移动的偏移量
private val EXTRA_VERTICAL_OFFSET = 16.dp

/**
 * 自定义MaterialEditText
 * Created by LLhon
 */
class MaterialEditText(context: Context, attr: AttributeSet) : AppCompatEditText(context, attr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = TEXT_SIZE
    }

    private val animator by lazy {
        //这里会到使用的时候才初始化一次
        ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)
    }

    private var floatingLabelShown = false
    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
    var useFloatingLabel = false
        set(value) {
            if (field != value) {
                field = value
                if (field) {
                    setPadding(paddingLeft, (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                } else {
                    setPadding(paddingLeft, (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                }
            }
        }

    init {
        val typedArray = context.obtainStyledAttributes(attr, R.styleable.MaterialEditText)
        useFloatingLabel = typedArray.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true)
        typedArray.recycle()
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)

        if (useFloatingLabel) {
            if (text.isNullOrEmpty() && floatingLabelShown) {
                //输入文字从有到无
                animator.reverse()
                floatingLabelShown = false
            } else if (!text.isNullOrEmpty() && !floatingLabelShown) {
                //输入文字从无到有
                animator.start()
                floatingLabelShown = true
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //渐变悬浮文字透明度
        mPaint.alpha = (floatingLabelFraction * 0xff).toInt()
        //绘制悬浮文字提示
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction), mPaint)
    }
}