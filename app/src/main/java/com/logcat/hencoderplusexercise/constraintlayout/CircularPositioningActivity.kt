package com.logcat.hencoderplusexercise.constraintlayout

import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.logcat.hencoderplusexercise.databinding.ActivityCircularPositioningBinding

/**
 *
 * Date: 2021/3/28 22:32
 * Created by LLhon
 */
class CircularPositioningActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCircularPositioningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCircularPositioningBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val earthAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 10000L
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                val params = mBinding.earth.layoutParams as ConstraintLayout.LayoutParams
                params.circleAngle = 45 + it.animatedFraction * 360
                mBinding.moon.requestLayout()
            }
        }

        val moonAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 2000L
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                val params = mBinding.moon.layoutParams as ConstraintLayout.LayoutParams
                params.circleAngle = 270 + it.animatedFraction * 360
                mBinding.moon.requestLayout()
            }
        }

        mBinding.sun.setOnClickListener {
            earthAnimator.start()
            moonAnimator.start()
        }
    }
}