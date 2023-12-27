package com.example.foregroundservice

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat

class ExampleService :Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
        val notificationintent=Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,notificationintent,0)
        val input= intent?.getStringExtra("inputExtra")
        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1,notification)
//        ServiceCompat.startForeground(0, notification, FOREGROUND_SERVICE_TYPE_LOCATION)

        //this method is called when all the task is completed
//        stopSelf()


        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    companion object{

        val CHANNEL_ID="exampleServiceChannel"
    }

}