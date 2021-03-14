package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityScalableviewBinding

/**
 *
 * Created by LLhon
 */
class ScalableViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityScalableviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityScalableviewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}