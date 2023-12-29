package com.example.customreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class ExampleBroadCastReceiver2 :BroadcastReceiver() {
    override fun onReceive(contxt: Context?, intent: Intent?) {

       // Toast.makeText(contxt, "EBR2 TRIGGERED", Toast.LENGTH_SHORT).show()

        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++
        stringExtra += "->SenderReceiver"

        val toastText = """
            SenderReceiver
            resultCode: $resultCode
            resultData: $resultData
            stringExtra: $stringExtra
            """.trimIndent()

        Toast.makeText(contxt, toastText, Toast.LENGTH_LONG).show()

        resultData = "SenderReceiver"
        resultExtras.putString("stringExtra", stringExtra)

        setResult(resultCode, resultData, resultExtras)

    }
}