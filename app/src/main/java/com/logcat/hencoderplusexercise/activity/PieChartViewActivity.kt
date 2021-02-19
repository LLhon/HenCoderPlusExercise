package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityPiechartBinding

/**
 *
 * Created by LLhon
 */
class PieChartViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPiechartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPiechartBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}