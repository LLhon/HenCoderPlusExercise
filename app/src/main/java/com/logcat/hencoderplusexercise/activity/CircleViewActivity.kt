package com.logcat.hencoderplusexercise.activity

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
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

//        val animator = ObjectAnimator.ofFloat(mBinding.circleView, "radius", 30.dp, 100.dp)
//        animator.startDelay = 1000
//        animator.duration = 1500
//        animator.start()

        val keyframe1 = Keyframe.ofFloat(0.2f, 20.dp)
        val keyframe2 = Keyframe.ofFloat(0.5f, 40.dp)
        val keyframe3 = Keyframe.ofFloat(1f, 80.dp)
        val holder = PropertyValuesHolder.ofKeyframe("radius", keyframe1, keyframe2,
            keyframe3)
        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(mBinding.circleView, holder)
        holderAnimator.startDelay = 1000
        holderAnimator.duration = 1500
        holderAnimator.start()

        mBinding.maskView.startAnimate()
    }
}