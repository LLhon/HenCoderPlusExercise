package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivitySquareBinding

/**
 *
 * Created by LLhon
 */
class SquareActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySquareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySquareBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}