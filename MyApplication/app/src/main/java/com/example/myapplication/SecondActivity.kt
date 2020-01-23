package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(this.javaClass.simpleName, "onCreate")

        var myApp = this.applicationContext as MyApplication


        btn_link.setOnClickListener {

        Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")).also {
                try {
                    startActivity(it)
                } catch (e: ActivityNotFoundException){

                    Toast.makeText(this@SecondActivity,
                        "No browser installed in your phone. Please install one and try again.",
                        Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
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