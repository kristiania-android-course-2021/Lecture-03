package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        Log.d(this.javaClass.simpleName, "onCreate")


        btn_open_second.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
        }

        //applicationContext is also Application instance
        var myApp : MyApplication = this.applicationContext as MyApplication
        var name = myApp.appName

    }

    override fun onStart() {
        super.onStart()

        Log.d(this.javaClass.simpleName, "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(this.javaClass.simpleName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(this.javaClass.simpleName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(this.javaClass.simpleName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.javaClass.simpleName, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(this.javaClass.simpleName, "onRestart")
    }
}