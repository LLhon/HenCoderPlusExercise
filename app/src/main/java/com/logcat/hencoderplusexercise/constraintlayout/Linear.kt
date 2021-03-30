package com.logcat.hencoderplusexercise.constraintlayout

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.VirtualLayout
import androidx.constraintlayout.widget.ConstraintLayout as ConstraintLayout

/**
 *
 * Date: 2021/3/30 23:06
 * Created by LLhon
 */
class Linear(context: Context, attrs: AttributeSet) : VirtualLayout(context, attrs) {

    private val constraintSet: ConstraintSet by lazy {
        ConstraintSet().apply {
            isForceId = false
        }
    }

    override fun updatePreLayout(container: ConstraintLayout) {
        super.updatePreLayout(container)
        constraintSet.clone(container)

        val viewIds = referencedIds;
        for (i in 1 until mCount) {

            val current = viewIds[i]
            val before = viewIds[i - 1]

            constraintSet.connect(current, ConstraintSet.START, before, ConstraintSet.START)
            constraintSet.connect(current, ConstraintSet.TOP, before, ConstraintSet.BOTTOM)

            constraintSet.applyTo(container)
        }
    }
}