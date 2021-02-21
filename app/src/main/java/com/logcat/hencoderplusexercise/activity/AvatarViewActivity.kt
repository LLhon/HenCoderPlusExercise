package com.logcat.hencoderplusexercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityAvatarBinding

/**
 *
 * Created by LLhon
 */
class AvatarViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAvatarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAvatarBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}