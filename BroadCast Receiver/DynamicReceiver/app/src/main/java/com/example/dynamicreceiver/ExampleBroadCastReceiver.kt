package com.example.dynamicreceiver



import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class ExampleBroadCastReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


       /* if (intent != null) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.action)){
                Log.d("PRABHAT", "onReceive: Boot")
                Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
            }

        }*/
        /*if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)){
            Log.d("PRABHAT", "onReceive:Connectivty ")
            Toast.makeText(context, "Connectivty changed", Toast.LENGTH_SHORT).show()

            val noConnectivity=intent?.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false)
            if (noConnectivity == true){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show()

            }

        }*/
        //custom receiver
      /* if ("com.example.PRABHAT".equals(intent?.action)){
           val receivedText=intent?.getStringExtra("com.codingflow.EXTRA_TEXT")
           Log.d("PRABHAT", "onReceive: ${receivedText.toString()}")
           Toast.makeText(context, receivedText.toString()+"prabhat" , Toast.LENGTH_SHORT).show()
       }*/

        //explicit broadcast
        Toast.makeText(context, "EBR Triggeered", Toast.LENGTH_SHORT).show()

    }
}