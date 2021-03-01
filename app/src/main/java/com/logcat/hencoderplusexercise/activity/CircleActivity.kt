package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityCircleBinding
import com.logcat.hencoderplusexercise.databinding.ActivityCircleviewBinding

/**
 *
 * Created by LLhon
 */
class CircleActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCircleviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCircleviewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}