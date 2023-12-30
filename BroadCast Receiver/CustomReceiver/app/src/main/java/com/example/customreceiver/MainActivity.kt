package com.example.customreceiver

//this  broadcast sender
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.customreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var textView: TextView
    private val exampleBroadCastReceiver2 = ExampleBroadCastReceiver2()



    private lateinit var  localBroadcastManager:LocalBroadcastManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView = findViewById(R.id.message_txt)
        localBroadcastManager= LocalBroadcastManager.getInstance(this)
        binding.sendBroadcast.setOnClickListener {


            val intent = Intent("com.codingflow.EXAMPLE_ACTION")

            localBroadcastManager.sendBroadcast(intent)


        }
    }

    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter("com.codingflow.EXAMPLE_ACTION")
        localBroadcastManager.registerReceiver(exampleBroadCastReceiver2, intentFilter)

    }

    override fun onStop() {
        super.onStop()
        localBroadcastManager.unregisterReceiver(exampleBroadCastReceiver2)
    }

}