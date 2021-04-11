package com.logcat.hencoderplusexercise.leakcanary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logcat.hencoderplusexercise.databinding.ActivityLeakOnLocalBinding
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 *
 * date: 2021/4/11 15:58
 * created by LLhon
 */
class LeakOnLocalActivity : AppCompatActivity() {

  private lateinit var mBinding: ActivityLeakOnLocalBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinding = ActivityLeakOnLocalBinding.inflate(layoutInflater)
    setContentView(mBinding.root)

    mBinding.btn.setOnClickListener {
      LeakOnLocal(this).leak()
      finish()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    gc()
  }

  fun gc() {
    thread {
      sleep(2000)
      Runtime.getRuntime().gc()
    }
  }

  protected fun finalize() {
    println("finalize...")
  }
}