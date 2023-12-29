package com.example.customreceiver

//this  broadcast sender
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.customreceiver.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     lateinit var  textView:TextView
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView=findViewById(R.id.message_txt)
        binding.sendBroadcast.setOnClickListener {
            val intent=Intent("com.example.PRABHAT")
            intent.putExtra("com.codingflow.EXTRA_TEXT","Broadcast received")
            sendBroadcast(intent)
        }
    }*/
  /*  val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val receivedText = intent.getStringExtra("com.codinginflow.EXTRA_TEXT")


            Log.d("PRABHAT", "onReceive: ${receivedText.toString()}")

            textView.text=receivedText.toString()
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onStart() {
        Log.d("PRABHAT", "onStart: ")
        super.onStart()
        val filter=IntentFilter("com.example.PRABHAT")
        registerReceiver(broadcastReceiver,filter, RECEIVER_NOT_EXPORTED)
    }

    override fun onStop() {
        Log.d("PRABHAT", "onStop: ")
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }*/

    //EXPLICIT BROADCAST RECEIVER
     override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       binding=ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)

       textView=findViewById(R.id.message_txt)
       binding.sendBroadcast.setOnClickListener {
//           val intent=Intent(this,ExampleBroadCastReceiver2::class.java)
//           val intent=Intent()
//           intent.setClass(this,ExampleBroadCastReceiver2::class.java)
          /* val componentName=ComponentName(this,ExampleBroadCastReceiver2::class.java)
           intent.setComponent(componentName)*/

           //with this component we can specify broadcast in another app as well
           //
          /* val componentName=ComponentName("com.example.dynamicreceiver","com.example.dynamicreceiver.ExampleBroadCastReceiver")
           intent.setComponent(componentName)*/

           //this will create setcomponent name set it internally
          /* intent.setClassName("com.example.dynamicreceiver","com.example.dynamicreceiver.ExampleBroadCastReceiver")
           sendBroadcast(intent)*/

           //another way is to by doing action to the intent and setting the intent filter in the another

           /*val intent=Intent("com.codingflow.EXAMPLE_ACTION")
           intent.setPackage("com.example.dynamicreceiver")
           sendBroadcast(intent)*/

           //another way for doing
           /*val intent=Intent("com.codingflow.EXAMPLE_ACTION")
           val packageManager=getPackageManager()
           val info=packageManager.queryBroadcastReceivers(intent,0)
           for (ResolveInfo in info){
               val componentName=ComponentName(ResolveInfo.activityInfo.packageName,ResolveInfo.activityInfo.name)
               intent.setComponent(componentName)
               sendBroadcast(intent)
           }*/

           //ordered receiver
           val extras=Bundle()
           extras.putString("stringExtra","start")

           val intent=Intent("com.codingflow.EXAMPLE_ACTION")
           intent.setPackage("com.example.dynamicreceiver")
//          sendBroadcast(intent)
          sendOrderedBroadcast(intent,null,ExampleBroadCastReceiver2(),null,0,"Start",extras)




       }
   }

}