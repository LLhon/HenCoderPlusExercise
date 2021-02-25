package com.logcat.hencoderplusexercise.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityAnimCameraBinding

/**
 *
 * Created by LLhon
 */
class AnimCameraViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAnimCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAnimCameraBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val bottomFlipAnimator = ObjectAnimator.ofFloat(mBinding.cameraView,
            "bottomFlip", 45f)
        bottomFlipAnimator.startDelay = 1000
        bottomFlipAnimator.duration = 1000

        val flipRotationAnimator = ObjectAnimator.ofFloat(mBinding.cameraView,
            "flipRotation", 270f)
        flipRotationAnimator.startDelay = 200
        flipRotationAnimator.duration = 1000

        val topFlipAnimator = ObjectAnimator.ofFloat(mBinding.cameraView,
            "topFlip", -45f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.start()

        /*val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 45f)
        val flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -45f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(mBinding.cameraView, bottomFlipHolder,
            flipRotationHolder, topFlipHolder)
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()*/
    }
}