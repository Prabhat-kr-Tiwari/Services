package com.example.dynamicreceiver

import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


//intitial commit


class MainActivity : AppCompatActivity() {


//    val exampleBroadCastReceiver=ExampleBroadCastReceiver()

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

    val exampleBroadCastReceiver = ExampleBroadCastReceiver()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val filter=IntentFilter("com.codingflow.EXAMPLE_ACTION")
        val filter = IntentFilter("com.codingflow.EXAMPLE_ACTION")

        registerReceiver(
            exampleBroadCastReceiver,
            filter, RECEIVER_NOT_EXPORTED
        )


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(exampleBroadCastReceiver)
    }


}