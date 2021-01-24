package com.example.eventsdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.evgenii.jsevaluator.JsEvaluator
import com.evgenii.jsevaluator.interfaces.JsCallback

class MainActivity : AppCompatActivity() /*, View.OnClickListener */  {


    var jsEvaluator: JsEvaluator? = null
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        jsEvaluator = JsEvaluator(this)

       //Todo find views by findViewById

        //Todo handle click events for button  1, 2

        //Todo call calculate for button1

        //Todo addTextChangedListener for editText
        
        //Todo aftertextchanged

    }

    fun calculate(expression: String) {
        jsEvaluator?.evaluate(expression, object : JsCallback {
            override fun onResult(result: String) {
                editText?.setText(result);
            }
            override fun onError(errorMessage: String) {
                editText?.setText(errorMessage);
            }
        })
    }

    fun showToast(button:Button?) {
        //Toasts are short lived pop up messages which appear and then auto disappear
        Toast.makeText(this, button?.text, Toast.LENGTH_LONG).show()
    }

    //Todo createmenu: associate menu R.menu.demo_menu
    //Todo handlemenu: menu Handle menu events R.menu.demo_menu

    //Todo explain onTouchEvent:
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(this.javaClass.simpleName, event.toString())
        return super.onTouchEvent(event)
    }

    //Todo explain onBackPressed of the activity
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(this.javaClass.simpleName, "onBackPressed" )
    }
}
