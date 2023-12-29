package com.example.customreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadCastReceiver2 :BroadcastReceiver() {
    override fun onReceive(contxt: Context?, intent: Intent?) {

        Toast.makeText(contxt, "EBR2 TRIGGERED", Toast.LENGTH_SHORT).show()

    }
}