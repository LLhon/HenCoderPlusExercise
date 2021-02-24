package com.logcat.hencoderplusexercise.activity

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityCircleBinding
import com.logcat.hencoderplusexercise.utils.dp

/**
 *
 * Created by LLhon
 */
class CircleViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCircleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCircleBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val animator = ObjectAnimator.ofFloat(mBinding.circleView, "radius", 30.dp, 100.dp)
        animator.startDelay = 500
        animator.duration = 1500
        animator.start()
    }
}