package com.logcat.hencoderplusexercise.constraintlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityFlowBinding

/**
 * 使用辅助控件 Flow 可实现类似流式布局样式，避免布局嵌套
 * Date: 2021/3/30 22:35
 * Created by LLhon
 */
class FlowActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFlowBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}