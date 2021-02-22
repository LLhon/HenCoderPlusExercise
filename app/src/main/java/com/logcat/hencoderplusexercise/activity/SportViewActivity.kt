package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivitySportBinding

/**
 *
 * Created by LLhon
 */
class SportViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySportBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}