package com.logcat.hencoderplusexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logcat.hencoderplusexercise.activity.*
import com.logcat.hencoderplusexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnDashboard.setOnClickListener {
            startActivity(Intent(this, DashBoardActivity::class.java))
        }
        mBinding.btnPiechart.setOnClickListener {
            startActivity(Intent(this, PieChartViewActivity::class.java))
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