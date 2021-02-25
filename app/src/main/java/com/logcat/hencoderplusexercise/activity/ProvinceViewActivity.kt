package com.logcat.hencoderplusexercise.activity

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityProvinceBinding
import com.logcat.hencoderplusexercise.view.animation.ProvinceEvaluator

/**
 *
 * Created by LLhon
 */
class ProvinceViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityProvinceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProvinceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val animator = ObjectAnimator.ofObject(mBinding.provinceView, "province",
            ProvinceEvaluator(), "香港特别行政区")
        animator.startDelay = 500
        animator.duration = 2000
        animator.start()
    }
}