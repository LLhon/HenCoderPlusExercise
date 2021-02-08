package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityDashboardBinding

/**
 *
 * Created by LLhon
 */
class DashBoardActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


    }
}