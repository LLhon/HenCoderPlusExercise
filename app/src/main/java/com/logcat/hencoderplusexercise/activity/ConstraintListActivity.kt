package com.logcat.hencoderplusexercise.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.constraintlayout.CircularPositioningActivity
import com.logcat.hencoderplusexercise.constraintlayout.CircularRevealActivity
import com.logcat.hencoderplusexercise.databinding.ActivityConstraintListBinding

/**
 *
 * Date: 2021/3/28 22:18
 * Created by LLhon
 */
class ConstraintListActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityConstraintListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityConstraintListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.button1.setOnClickListener {
            startActivity(Intent(this, CircularRevealActivity::class.java))
        }
        mBinding.button2.setOnClickListener {
            startActivity(Intent(this, CircularPositioningActivity::class.java))
        }
        mBinding.button3.setOnClickListener {
            startActivity(Intent(this, AvatarViewActivity::class.java))
        }
        mBinding.button4.setOnClickListener {

        }
        mBinding.button5.setOnClickListener {
            startActivity(Intent(this, SportViewActivity::class.java))
        }
        mBinding.button6.setOnClickListener {
            startActivity(Intent(this, MultilineTextActivity::class.java))
        }
    }
}