package com.example.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jobscheduler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.scheduleJob.setOnClickListener {

            val componentName=ComponentName(this,ExampleJobService::class.java)
            val jobInfo=JobInfo.Builder(123,componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build()

            val scheduler:JobScheduler=getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode=scheduler.schedule(jobInfo)
            if (resultCode==JobScheduler.RESULT_SUCCESS){
                Log.d(TAG, "  Job Scheduled")
            }else{
                Log.d(TAG, "  Job Scheduled failed")

            }


        }
        binding.cancelJob.setOnClickListener {

            val scheduler:JobScheduler=getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            scheduler.cancel(123)
            Log.d(TAG, "Job Cancel")
        }




    }
    companion object{
        private val TAG="ExampleJobService"
    }
}