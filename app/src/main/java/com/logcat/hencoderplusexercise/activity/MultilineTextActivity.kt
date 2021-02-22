package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityMultilineTextBinding

/**
 *
 * Created by LLhon
 */
class MultilineTextActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMultilineTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMultilineTextBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}