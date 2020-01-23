package com.example.myapplication

import android.app.Application

class MyApplication: Application() {

    var appName : String = ""

    override fun onCreate() {
        super.onCreate()

        appName = this.getString(R.string.app_name)
    }

}