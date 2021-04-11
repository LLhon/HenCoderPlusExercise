package com.logcat.hencoderplusexercise.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.constraintlayout.*
import com.logcat.hencoderplusexercise.databinding.ActivityConstraintListBinding
import com.logcat.hencoderplusexercise.databinding.ActivityMotionListBinding
import com.logcat.hencoderplusexercise.motionlayout.CoordinatorActivity
import com.logcat.hencoderplusexercise.motionlayout.MotionLayoutActivity
import com.logcat.hencoderplusexercise.motionlayout.YoutubeLikeActivity

/**
 *
 * Date: 2021/3/31 23:09
 * Created by LLhon
 */
class MotionListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMotionListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMotionListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.button1.setOnClickListener {
            startActivity(Intent(this, MotionLayoutActivity::class.java))
        }
        mBinding.button2.setOnClickListener {
            startActivity(Intent(this, CoordinatorActivity::class.java))
        }
        mBinding.button3.setOnClickListener {
            startActivity(Intent(this, YoutubeLikeActivity::class.java))
        }
    }
}