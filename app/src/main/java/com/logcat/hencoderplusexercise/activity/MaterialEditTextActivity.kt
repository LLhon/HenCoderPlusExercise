package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityMaterialedittextBinding

/**
 *
 * Created by LLhon
 */
class MaterialEditTextActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMaterialedittextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMaterialedittextBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

//        mBinding.met.useFloatingLabel = false
    }
}