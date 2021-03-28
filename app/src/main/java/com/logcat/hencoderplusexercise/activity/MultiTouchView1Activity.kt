package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityMultitouch1Binding

/**
 * Des:
 * Date: 2021/3/21 11:48
 * Created by LLhon
 */
class MultiTouchView1Activity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMultitouch1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMultitouch1Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}