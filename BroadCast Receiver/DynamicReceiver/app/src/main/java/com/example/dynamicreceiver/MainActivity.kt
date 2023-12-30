package com.example.dynamicreceiver

import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.Manifest.permission


class MainActivity : AppCompatActivity() {


//    val exampleBroadCastReceiver=OrderedReceiver1()

    /* override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
     }

     override fun onStart() {
         super.onStart()

         val filter=IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
         registerReceiver(exampleBroadCastReceiver,filter)
     }

     override fun onStop() {
         super.onStop()
         unregisterReceiver(exampleBroadCastReceiver)
     }*/
    //custom receiver
    /*@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter=IntentFilter("com.example.PRABHAT")
        registerReceiver(exampleBroadCastReceiver,filter, RECEIVER_NOT_EXPORTED)
    }*/


    /* override fun onDestroy() {
         super.onDestroy()
         unregisterReceiver(exampleBroadCastReceiver)

     }*/

    //explicit receiver
    /*@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }*/
    //ordered receiver

    val orderedReceiver1 = OrderedReceiver1()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val filter=IntentFilter("com.codingflow.EXAMPLE_ACTION")
        val filter = IntentFilter("com.codingflow.EXAMPLE_ACTION")
        filter.priority = 1


     registerReceiver( orderedReceiver1, filter,android.Manifest.permission.VIBRATE,null,0)


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(orderedReceiver1)
    }


}