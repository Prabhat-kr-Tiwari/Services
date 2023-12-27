package com.example.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ExampleJobService:JobService() {
    private var jobCancelled=false
    override fun onStartJob(params: JobParameters?): Boolean {

        Log.d(TAG, "onStartJob: Job Started")
        doBackGroundWork(params)
        return true
    }

    private fun doBackGroundWork(params: JobParameters?) {
        Thread(Runnable {

            //some method here
            for (i in 0..100){
                Log.d(TAG, "run: $i")
                if (jobCancelled){
                    return@Runnable
                }
                Thread.sleep(1000)
            }
            Log.d(TAG, "doBackGroundWork: Job Finished")
            jobFinished(params,false)
        }).start()

    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d(TAG, "onStopJob: Job Cancelled before completion")
        jobCancelled=true
        return false
    }
    companion object{
        private val TAG="ExampleJobService"
    }

}