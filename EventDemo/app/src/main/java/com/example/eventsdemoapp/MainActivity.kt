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
import android.widget.Toast
import com.evgenii.jsevaluator.JsEvaluator
import com.evgenii.jsevaluator.interfaces.JsCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    var jsEvaluator: JsEvaluator? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        this.button3.setOnClickListener(this)

        this.button2.setOnClickListener( object: View.OnClickListener{
            override fun onClick(view: View?) {
                showToast(view as Button)
            }
        })

        this.button1.setOnClickListener{view: View ->
            calculate()
        }

        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(editable: Editable?) {

                Log.d(this@MainActivity.javaClass.simpleName, editable.toString())

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })



        this.button4.setOnTouchListener( object : View.OnTouchListener{
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {

                Log.d("button4",motionEvent.toString())

                return true
            }
        })

        jsEvaluator = JsEvaluator(this)

    }


    private fun calculate() {

        jsEvaluator?.evaluate(editText.text.toString(), object : JsCallback {
            override fun onResult(result: String) {
                editText.setText(result);
            }

            override fun onError(errorMessage: String) {
                editText.setText(errorMessage);

            }
        })

        Toast.makeText(this, editText?.text, Toast.LENGTH_LONG).show()

    }


    override fun onClick(view: View?) {

        when(view?.id) {
            R.id.button3->
                showToast(view as Button)
        }

    }

    private fun showToast(button:Button? ) {


        Toast.makeText(this, button?.text, Toast.LENGTH_LONG).show()

    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(this@MainActivity.javaClass.simpleName,event.toString())
        return super.onTouchEvent(event)
    }



    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(this@MainActivity.javaClass.simpleName,"onBackPressed")

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.demo_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

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


}
