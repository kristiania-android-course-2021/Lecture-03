package com.example.gettingresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //Declaring static in  Kotlin

    companion object {
        val REQUEST_FRUIT_SELECTION = 100;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSelect.setOnClickListener {

            var intent = Intent(this@MainActivity, SelectorActivity::class.java)
            //Getting a Result from SelectorActivity
            this@MainActivity.startActivityForResult(intent, REQUEST_FRUIT_SELECTION)
        }


    }

    //https://developer.android.com/training/basics/intents/result

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( resultCode== Activity.RESULT_OK){

            when(requestCode){

                REQUEST_FRUIT_SELECTION->
                {
                    var drawableResId = data?.getIntExtra("resId",0)


                    imageViewFruit.setImageResource(drawableResId!!)
                }
            }
        }
    }
}
