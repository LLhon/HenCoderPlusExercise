package com.logcat.hencoderplusexercise.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityYoutubeBinding

/**
 *
 * Date: 2021/3/31 23:41
 * Created by LLhon
 */
class YoutubeLikeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityYoutubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityYoutubeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}