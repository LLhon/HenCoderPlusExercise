package com.logcat.hencoderplusexercise.constraintlayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.databinding.ActivityConstraintStartBinding

/**
 * 使用 ConstraintSet 对象来动态修改布局
 * Date: 2021/3/30 22:41
 * Created by LLhon
 */
class ConstraintSetActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityConstraintStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityConstraintStartBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


    }

    fun onClick(view: View) {
        val constraintLayout = view as ConstraintLayout
        val constraintSet = ConstraintSet().apply {
            //防止布局中无id控件时报错
            isForceId = false
            //从xml布局中获取约束集
            clone(this@ConstraintSetActivity, R.layout.activity_constraint_end)
        }
        //添加过渡动画
        TransitionManager.beginDelayedTransition(constraintLayout)
        //使生效
        constraintSet.applyTo(constraintLayout)
    }
}