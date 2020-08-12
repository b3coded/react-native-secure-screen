package com.b3coded.reactnativesecurescreen

import android.view.WindowManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.UiThreadUtil.runOnUiThread


class SecureScreenModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
  private val PREVENT_SCREENSHOT_ERROR_CODE = "PREVENT_SCREENSHOT_ERROR_CODE"
  private val REACT_CLASS = "RNSecureScreen"

  override fun getName(): String {
    return REACT_CLASS
  }

  @ReactMethod
  fun forbid(promise: Promise) {
    runOnUiThread(Runnable {
      try {
        currentActivity!!.window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        promise.resolve("Done. Screenshot taking locked.")
      } catch (e: Exception) {
        promise.reject(PREVENT_SCREENSHOT_ERROR_CODE, "Forbid screenshot taking failure.")
      }
    })
  }

  @ReactMethod
  fun allow(promise: Promise) {
    runOnUiThread(Runnable {
      try {
        currentActivity!!.window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        promise.resolve("Done. Screenshot taking unlocked.")
      } catch (e: Exception) {
        promise.reject(PREVENT_SCREENSHOT_ERROR_CODE, "Allow screenshot taking failure.")
      }
    })
  }
}
