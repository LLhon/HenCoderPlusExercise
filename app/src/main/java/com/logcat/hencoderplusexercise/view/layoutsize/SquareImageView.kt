package com.logcat.hencoderplusexercise.view.layoutsize

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.logcat.hencoderplusexercise.utils.dp
import kotlin.math.min

/**
 *
 * Created by LLhon
 */
class SquareImageView(context: Context, attr: AttributeSet) : AppCompatImageView(context, attr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }
}