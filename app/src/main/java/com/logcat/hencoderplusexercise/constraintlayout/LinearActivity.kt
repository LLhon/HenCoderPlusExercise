package com.logcat.hencoderplusexercise.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityLinearBinding

/**
 *
 * Date: 2021/3/30 23:08
 * Created by LLhon
 */
class LinearActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLinearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLinearBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}