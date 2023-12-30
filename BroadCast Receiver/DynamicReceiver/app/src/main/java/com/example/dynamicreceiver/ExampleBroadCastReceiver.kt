package com.example.dynamicreceiver



import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class ExampleBroadCastReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "EBR triggerred", Toast.LENGTH_SHORT).show()



    }
}