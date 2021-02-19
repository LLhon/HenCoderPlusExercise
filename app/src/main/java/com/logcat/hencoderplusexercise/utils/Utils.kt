package com.logcat.hencoderplusexercise.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * Created by LLhon
 */

fun dp2px(value: Float) : Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
    Resources.getSystem().displayMetrics)