package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityDragHelperBinding
import com.logcat.hencoderplusexercise.databinding.ActivityDragListenerBinding

/**
 * Des:
 * Date: 2021/3/22 20:28
 * Created by LLhon
 */
class ViewDragHelperActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDragHelperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDragHelperBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}