package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityTaglayoutBinding

/**
 *
 * Created by LLhon
 */
class TagLayoutActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTaglayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTaglayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}