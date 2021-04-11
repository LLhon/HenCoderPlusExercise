package com.logcat.hencoderplusexercise

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 *
 * Date: 2021/4/11 22:34
 * Created by LLhon
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }
}