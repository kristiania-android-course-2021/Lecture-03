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

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    //Todo How to include JsEvaluator library into your project
    var jsEvaluator: JsEvaluator? = null
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        jsEvaluator = JsEvaluator(this)

       //Todo find views by findViewById

        var button1 = findViewById(R.id.button1) as Button // Using typecast
        var button2 = findViewById<Button>(R.id.button2)   // Using generic
        var button3 = findViewById<Button>(R.id.button3)   // Using generic

        editText = findViewById<EditText>(R.id.editText)

        button2.setOnClickListener( object: View.OnClickListener{
            override fun onClick(view: View?) {
                showToast(view as Button)
            }
        })

        button1.setOnClickListener { view: View ->
            //Todo: what does ? mean?
            //Todo: Why we are using editableText of editText
            var expression = editText?.editableText.toString()

            //Todo what does !! mean?
            calculate(expression!!)
        }

        button3.setOnClickListener(this)

        editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {
                var expression = editable.toString()
                if( expression.isNotBlank() ){
                    var lastChar = expression.get(expression.length-1);
                    if(lastChar== '=') {
                        calculate( expression.substring(0, expression.length-1) )
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
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

    override fun onClick(view: View?) {
        //Checking id of the view
        when(view?.id) {
            R.id.button3 ->
                showToast(view as Button)
        }
    }

    fun showToast(button:Button?) {
        //Toasts are short lived pop up messages which appear and then auto disappear
        Toast.makeText(this, button?.text, Toast.LENGTH_LONG).show()
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(this.javaClass.simpleName, event.toString())
        return super.onTouchEvent(event)
    }

    //Todo associate menu R.menu.demo_menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.demo_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Todo Handle menu events R.menu.demo_menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_headphone->
                Toast.makeText(this, getString(R.string.heaphone), Toast.LENGTH_LONG).show()
            R.id.item_help->
                Toast.makeText(this, getString(R.string.help), Toast.LENGTH_LONG).show()
            R.id.item3->
                Toast.makeText(this, getString(R.string.bell_menu), Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //Todo override onBackPressed of the activity
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(this.javaClass.simpleName,"onBackPressed")
    }
}
