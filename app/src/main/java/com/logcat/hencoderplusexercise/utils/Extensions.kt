package com.logcat.hencoderplusexercise.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * 扩展函数
 * Created by LLhon
 */

val Float.px
  get() = TypedValue.applyDimension(
      TypedValue.COMPLEX_UNIT_DIP,
      this,
      Resources.getSystem().displayMetrics
  )