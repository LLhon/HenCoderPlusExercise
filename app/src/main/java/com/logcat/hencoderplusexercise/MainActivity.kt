package com.logcat.hencoderplusexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logcat.hencoderplusexercise.activity.*
import com.logcat.hencoderplusexercise.constraintlayout.CircularRevealActivity
import com.logcat.hencoderplusexercise.databinding.ActivityMainBinding
import com.logcat.hencoderplusexercise.leakcanary.LeakOnLocalActivity

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
        mBinding.button7.setOnClickListener {
            startActivity(Intent(this, CameraViewActivity::class.java))
        }
        mBinding.button8.setOnClickListener {
            startActivity(Intent(this, CircleViewActivity::class.java))
        }
        mBinding.button9.setOnClickListener {
            startActivity(Intent(this, PointFViewActivity::class.java))
        }
        mBinding.button10.setOnClickListener {
            startActivity(Intent(this, AnimCameraViewActivity::class.java))
        }
        mBinding.button11.setOnClickListener {
            startActivity(Intent(this, ProvinceViewActivity::class.java))
        }
        mBinding.button12.setOnClickListener {
            startActivity(Intent(this, MeshDrawableActivity::class.java))
        }
        mBinding.button13.setOnClickListener {
            startActivity(Intent(this, MaterialEditTextActivity::class.java))
        }
        mBinding.button14.setOnClickListener {
            startActivity(Intent(this, SquareActivity::class.java))
        }
        mBinding.button15.setOnClickListener {
            startActivity(Intent(this, CircleActivity::class.java))
        }
        mBinding.button16.setOnClickListener {
            startActivity(Intent(this, TagLayoutActivity::class.java))
        }
        mBinding.button17.setOnClickListener {
            startActivity(Intent(this, ScalableViewActivity::class.java))
        }
        mBinding.button18.setOnClickListener {
            startActivity(Intent(this, MultiTouchView1Activity::class.java))
        }
        mBinding.button19.setOnClickListener {
            startActivity(Intent(this, DragListenerActivity::class.java))
        }
        mBinding.button20.setOnClickListener {
            startActivity(Intent(this, ViewDragHelperActivity::class.java))
        }
        mBinding.button21.setOnClickListener {
            startActivity(Intent(this, ConstraintListActivity::class.java))
        }
        mBinding.button22.setOnClickListener {
            startActivity(Intent(this, LeakOnLocalActivity::class.java))
        }
    }
}