package com.example.ntentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.ntentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startService.setOnClickListener {


            val input=binding.editText.text.toString()
            val serviceIntent=Intent(this,ExampleIntentService::class.java)
            serviceIntent.putExtra("inputExtra",input)
            ContextCompat.startForegroundService(this,serviceIntent)
//            startService(serviceIntent)
        }
    }
}