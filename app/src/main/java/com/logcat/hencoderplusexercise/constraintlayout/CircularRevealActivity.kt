package com.logcat.hencoderplusexercise.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityCircularrevealBinding

/**
 * Des:
 * Date: 2021/3/25 0:05
 * Created by LLhon
 */
class CircularRevealActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCircularrevealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCircularrevealBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}