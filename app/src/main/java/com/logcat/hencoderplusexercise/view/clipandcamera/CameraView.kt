package com.logcat.hencoderplusexercise.view.clipandcamera

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.logcat.hencoderplusexercise.R
import com.logcat.hencoderplusexercise.utils.dp

/**
 * 范围裁切和几何变换
 * Created by LLhon
 */
class CameraView(context: Context, attr: AttributeSet) : View(context, attr) {

    private val IMAGE_WIDTH = 200.dp
    private val IMAGE_PADDING = 100.dp
    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBitmap = getAvatar(IMAGE_WIDTH.toInt())
    private val mPath = Path().apply {
        addOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH,
            Path.Direction.CCW)
    }
    private val mMatrix = Matrix()
    private val mCamera = Camera().apply {
        rotateX(30f)
        setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
//        canvas.save()
        //裁切矩形范围
//        canvas.clipRect(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH,
//            IMAGE_PADDING + IMAGE_WIDTH / 2)
        //裁切路径范围
//        canvas.clipPath(mPath)
        //Canvas的几何变换
//        canvas.translate(-IMAGE_PADDING, -IMAGE_PADDING)
//        canvas.rotate(30f)
        //Matrix的几何变换
//        mMatrix.preRotate(30f)
//        canvas.setMatrix(mMatrix)
//        canvas.drawBitmap(mBitmap, IMAGE_PADDING, IMAGE_PADDING, mPaint)
//        canvas.restore()

        //上半部分
        canvas.save()
        canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2)
        canvas.rotate(-30f)
        canvas.clipRect(-IMAGE_WIDTH, -IMAGE_WIDTH, IMAGE_WIDTH, 0f)
        canvas.rotate(30f)
        canvas.translate(-(IMAGE_PADDING + IMAGE_WIDTH / 2), -(IMAGE_PADDING + IMAGE_WIDTH / 2))
        canvas.drawBitmap(mBitmap, IMAGE_PADDING, IMAGE_PADDING, mPaint)
        canvas.restore()

        //下半部分
        canvas.save()
        canvas.translate(IMAGE_PADDING + IMAGE_WIDTH / 2, IMAGE_PADDING + IMAGE_WIDTH / 2)
        canvas.rotate(-30f)
        mCamera.applyToCanvas(canvas)
        canvas.clipRect(-IMAGE_WIDTH, 0f, IMAGE_WIDTH, IMAGE_WIDTH)
        canvas.rotate(30f)
        canvas.translate(-(IMAGE_PADDING + IMAGE_WIDTH / 2), -(IMAGE_PADDING + IMAGE_WIDTH / 2))
        canvas.drawBitmap(mBitmap, IMAGE_PADDING, IMAGE_PADDING, mPaint)
        canvas.restore()
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