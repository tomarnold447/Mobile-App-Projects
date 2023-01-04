package com.example.lab4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent){
        Toast.makeText(context, "BroadCast Event has been received", Toast.LENGTH_LONG).show()
    }
}