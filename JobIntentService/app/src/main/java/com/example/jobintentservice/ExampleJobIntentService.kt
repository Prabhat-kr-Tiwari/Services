package com.example.jobintentservice

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.core.app.JobIntentService

class ExampleJobIntentService :JobIntentService() {







    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }
    override fun onHandleWork(intent: Intent) {

        //in the intent service we havae waklock to wake cpu
        //but jobintentservice will do automatically

        Log.d(TAG, "onHandleWork: ")

        val input=intent.getStringExtra("inputExtra")
        for (i in 0 ..10){
            if (isStopped) return
            SystemClock.sleep(1000)
            Log.d(TAG, "$input-$i")
        }

        //it will not stop automatically we have to handle it

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    //this will be called when device is under strong memory pressure
    override fun onStopCurrentWork(): Boolean {
        Log.d(TAG, "onStopCurrentWork: ")
        return super.onStopCurrentWork()
    }
    
    companion object{
        val TAG="ExampleJobIntentService"
        fun enqueueWork(context: Context, work :Intent){

            enqueueWork(context,ExampleJobIntentService::class.java,123,work)

        }
    }
}