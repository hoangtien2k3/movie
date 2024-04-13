package com.hoangtien2k3.themoviedb.common

import android.os.CountDownTimer

class MyCountDownTimer(startTime: Long, interval: Long, private val func: () -> Unit) :
    CountDownTimer(startTime, interval) {
    override fun onFinish() = func()
    override fun onTick(timer: Long) {}
}