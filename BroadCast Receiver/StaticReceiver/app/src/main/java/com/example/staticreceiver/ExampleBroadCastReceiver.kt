package com.example.staticreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class ExampleBroadCastReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


        if (intent != null) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.action)){
                Log.d("PRABHAT", "onReceive: Boot")
                Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
            }

        }
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)){
            Log.d("PRABHAT", "onReceive:Connectivty ")
            Toast.makeText(context, "Connectivty changed", Toast.LENGTH_SHORT).show()
        }
    }
}