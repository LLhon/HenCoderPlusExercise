package com.logcat.hencoderplusexercise.activity

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.PointF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityPointfBinding
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class PointFViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPointfBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPointfBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val animator = ObjectAnimator.ofObject(mBinding.pointFView, "point",
            PointEvaluator(), PointF(20.dp, 20.dp), PointF(60.dp, 60.dp), PointF(120.dp, 120.dp),
            PointF(180.dp, 60.dp), PointF(240.dp, 20.dp))
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()
    }

    class PointEvaluator : TypeEvaluator<PointF> {

        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val startX = startValue.x
            val endX = endValue.x
            val currentX = startX + (endX - startX) * fraction
            val startY = startValue.y
            val endY = endValue.y
            val currentY = startY + (endY - startY) * fraction
            return PointF(currentX, currentY)
        }
    }
}