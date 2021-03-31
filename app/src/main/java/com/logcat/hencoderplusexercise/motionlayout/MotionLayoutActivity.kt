package com.logcat.hencoderplusexercise.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.databinding.ActivityMotionLayoutBinding

/**
 *
 * Date: 2021/3/31 22:55
 * Created by LLhon
 */
class MotionLayoutActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMotionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMotionLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.ratingFilmRating.rating = 4.5f
        mBinding.textFilmTitle.text = getString(R.string.film_title)
        mBinding.textFilmDescription.text = getString(R.string.film_description)
    }
}