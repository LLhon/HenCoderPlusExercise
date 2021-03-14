package com.logcat.hencoderplusexercise.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.logcat.hencoderplusexercise.R

/**
 *
 * Created by LLhon
 */

fun dp2px(value: Float) : Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
    Resources.getSystem().displayMetrics)

fun getAvatar(resources: Resources, width: Int) : Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
    return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
}