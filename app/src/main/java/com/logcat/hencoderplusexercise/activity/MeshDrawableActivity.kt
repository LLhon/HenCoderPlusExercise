package com.logcat.hencoderplusexercise.activity

import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import com.logcat.hencoderplusexercise.databinding.ActivityMeshdrawableBinding

/**
 *
 * Created by LLhon
 */
class MeshDrawableActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMeshdrawableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMeshdrawableBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

//        val bitmap = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888)
//        bitmap.toDrawable(resources)
//        val drawable = ColorDrawable()
//        drawable.toBitmap(20, 20, Bitmap.Config.ARGB_8888)
    }
}