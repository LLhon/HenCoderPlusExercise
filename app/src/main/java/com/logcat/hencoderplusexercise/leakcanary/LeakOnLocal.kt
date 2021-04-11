package com.logcat.hencoderplusexercise.leakcanary

import android.os.SystemClock
import android.util.Log

/**
 *
 * date: 2021/4/11 16:02
 * created by LLhon
 */
class LeakOnLocal(var obj: Any?) : Thread() {

    override fun run() {
        super.run()
        var local = obj //把值赋值给成员变量
        obj = null //确保成员变量不再引用对象

        SystemClock.sleep(100000)
        Log.e("local : ", local.toString())
    }

    fun leak() {
        start()
    }
}