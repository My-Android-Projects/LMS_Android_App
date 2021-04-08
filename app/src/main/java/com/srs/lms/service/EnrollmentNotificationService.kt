package com.srs.lms.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class EnrollmentNotificationService: Service() {
    private val CHANNEL_ID="LMS Service"
    companion object{
        fun sendEnrollmentNotification(context: Context,message:String)
        {
            val notificationIntent=Intent(context,EnrollmentNotificationService::class.java)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}