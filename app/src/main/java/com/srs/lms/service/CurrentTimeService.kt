package com.srs.lms.service

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*


class CurrentTimeService: Service() {
    private val myBinder=MyLocalBinder()
    inner class MyLocalBinder: Binder(){
        fun getService():CurrentTimeService{
            return this@CurrentTimeService
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }
    fun getCurrentTime():String{
        val displayDate=SimpleDateFormat("dd/MM/yyyy HH:mm::ss",Locale.US)
        return displayDate.format(Date())
    }

}
