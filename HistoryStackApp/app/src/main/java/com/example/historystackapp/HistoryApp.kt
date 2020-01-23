package com.example.historystackapp

import android.app.Application
import android.util.Log

class HistoryApp: Application() {

     val TAG:String = "MainActivity";

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "***Application Process started***")
    }

}