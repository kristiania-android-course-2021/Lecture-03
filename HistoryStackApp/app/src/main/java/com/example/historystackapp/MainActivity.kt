package com.example.historystackapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var activityNumber : Int = 1
    var TAG : String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if( this.intent.hasExtra("number") ){
            activityNumber = this.intent.getIntExtra("number", 1)
        }

        textView.text = "Activity id $activityNumber"

        TAG = this.javaClass.simpleName + activityNumber


        this.nextButton.setOnClickListener{

            //Code to start new instance of the same activity with new Activity number

            var intent = Intent(this@MainActivity, MainActivity::class.java)
            intent.putExtra("number", activityNumber +1 )
            this@MainActivity.startActivity(intent)
        }

        Log.d(TAG, "onCreate")

    }



    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

}
