package com.example.foregroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foregroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            startService()
        }
        binding.stopService.setOnClickListener {
            stopService()
        }

    }
    public fun startService(){

        val input=binding.editText.text.toString()
        val serviceIntent=Intent(this,ExampleService::class.java)
        serviceIntent.putExtra("inputExtra",input)


//        startService(serviceIntent)
        startForegroundService(serviceIntent)

    }
    fun  stopService(){
        val serviceIntent=Intent(this,ExampleService::class.java)
        stopService(serviceIntent)

    }

}