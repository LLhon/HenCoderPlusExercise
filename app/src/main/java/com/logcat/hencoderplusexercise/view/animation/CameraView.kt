package com.logcat.hencoderplusexercise.view.animation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

/**
 * 属性动画
 * Created by LLhon
 */
class CameraView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val IMAGE_WIDTH = 200.dp
    private val IMAGE_PADDING = 100.dp
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBitmap = getAvatar(IMAGE_WIDTH.toInt())
    private val mCamera = Camera().apply {
        setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }
    //底部翻折
    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    //顶部翻折
    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    //翻折角度
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {

        //上半部分
        canvas.withSave {
            canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2)
            canvas.rotate(-flipRotation)
            mCamera.save()
            mCamera.rotateX(topFlip)
            mCamera.applyToCanvas(canvas)
            mCamera.restore()
            canvas.clipRect(-IMAGE_WIDTH, -IMAGE_WIDTH, IMAGE_WIDTH, 0f)
            canvas.rotate(flipRotation)
            canvas.translate(-(IMAGE_PADDING + IMAGE_WIDTH / 2), -(IMAGE_PADDING + IMAGE_WIDTH / 2))
            canvas.drawBitmap(mBitmap, IMAGE_PADDING, IMAGE_PADDING, mPaint)
        }

        //下半部分
        canvas.withSave {
            canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2)
            canvas.rotate(-flipRotation)
            mCamera.save()
            mCamera.rotateX(bottomFlip)
            mCamera.applyToCanvas(canvas)
            mCamera.restore()
            canvas.clipRect(-IMAGE_WIDTH, 0f, IMAGE_WIDTH, IMAGE_WIDTH)
            canvas.rotate(flipRotation)
            canvas.translate(-(IMAGE_PADDING + IMAGE_WIDTH / 2), -(IMAGE_PADDING + IMAGE_WIDTH / 2))
            canvas.drawBitmap(mBitmap, IMAGE_PADDING, IMAGE_PADDING, mPaint)
        }
    }

    private fun getAvatar(width: Int) : Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian, options)
    }
}