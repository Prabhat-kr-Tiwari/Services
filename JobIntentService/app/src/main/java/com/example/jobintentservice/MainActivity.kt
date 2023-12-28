package com.example.jobintentservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobintentservice.databinding.ActivityMainBinding
import com.example.jobintentservice.ExampleJobIntentService.Companion

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.enqueueWork.setOnClickListener {


            val input=binding.editText.text.toString()
            val intent=Intent(this,ExampleJobIntentService::class.java)
            intent.putExtra("inputExtra",intent)





        }
    }
}