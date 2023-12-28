package com.example.ntentservice

import android.app.IntentService
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.ntentservice.App.Companion

class ExampleIntentService() : IntentService("ExampleIntentService") {

    private  lateinit var  wakeLock :PowerManager.WakeLock
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")

        //wake manager
//        awakelog will make the cpu running when screen is turned of and our service
//        keeps running when the user screen is of
        val powermanager=getSystemService(POWER_SERVICE) as PowerManager
        wakeLock=powermanager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"ExampleApp:WakeLock")
        wakeLock.acquire()
        Log.d(TAG, "onCreate: Wake log acquired")
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
             val notificaton=NotificationCompat.Builder(this ,App.CHANNEL_ID)
                 .setContentTitle("Example Intent Service")
                 .setContentText("Running...")
                 .setSmallIcon(R.drawable.ic_android)
                 .build()
            startForeground(1,notificaton)
        }
    }
    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent: ")
        val input=intent?.getStringExtra("inputExtra")
        for (i in 0..10){
            Log.d(TAG, input+"-"+i)
            SystemClock.sleep(1000)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        wakeLock.release()
        Log.d(TAG, "onDestroy: Wake lock released")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object{
        private val TAG="ExampleIntentService"
    }

}