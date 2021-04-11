package com.logcat.hencoderplusexercise.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.logcat.hencoderplusexercise.databinding.ActivityCoordinatorBinding

/**
 *
 * Date: 2021/3/31 23:29
 * Created by LLhon
 */
class CoordinatorActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCoordinatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener {appBarLayout, verticalOffset ->
            mBinding.motionLayout.progress = -verticalOffset / mBinding.appBar.totalScrollRange.toFloat()
        })
    }
}