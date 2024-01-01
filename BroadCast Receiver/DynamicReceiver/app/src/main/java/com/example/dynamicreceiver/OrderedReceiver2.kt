package com.example.dynamicreceiver



import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Looper
import android.os.SystemClock
import android.widget.Toast
import java.util.logging.Handler


class OrderedReceiver2 :BroadcastReceiver() {
    companion object{
        val handler= android.os.Handler()
    }
    override fun onReceive(context: Context?, intent: Intent?) {

        val pendingResult=goAsync()


        Thread(Runnable{
            SystemClock.sleep(10000)

            var resultCode = pendingResult.resultCode
            var resultData =  pendingResult.resultData
            val resultExtras =  pendingResult.getResultExtras(true)
            var stringExtra = resultExtras.getString("stringExtra")

            resultCode++
            stringExtra += "->OR2"


             val toastText = """
            OR1
            resultCode: $resultCode
            resultData: $resultData
            stringExtra: $stringExtra
            """.trimIndent()



            handler.post {
                val toast = Toast.makeText(context, toastText, Toast.LENGTH_LONG)
                toast.show()
            }



            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

            resultData = "OR2"
            resultExtras.putString("stringExtra", stringExtra)

            pendingResult.setResult(resultCode, resultData, resultExtras)
            pendingResult.finish()

        }).start()



    }

}