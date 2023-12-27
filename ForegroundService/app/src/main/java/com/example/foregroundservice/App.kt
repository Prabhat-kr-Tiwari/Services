package com.example.foregroundservice

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import java.nio.file.attribute.AclEntry.Builder

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val serviceChannel=NotificationChannel(
                CHANNEL_ID,
                "Example Service channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager=getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)

        }
    }

    companion object{

        private val CHANNEL_ID="exampleServiceChannel"
    }

}
