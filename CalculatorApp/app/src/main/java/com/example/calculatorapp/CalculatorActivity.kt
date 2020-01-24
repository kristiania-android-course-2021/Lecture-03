package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.evgenii.jsevaluator.JsEvaluator
import com.evgenii.jsevaluator.interfaces.JsCallback
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() , View.OnClickListener {

    var jsEvaluator : JsEvaluator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        this.button0.setOnClickListener(this)
        this.button1.setOnClickListener(this)
        this.button2.setOnClickListener(this)
        this.button3.setOnClickListener(this)
        this.button4.setOnClickListener(this)
        this.button5.setOnClickListener(this)
        this.button6.setOnClickListener(this)
        this.button7.setOnClickListener(this)
        this.button8.setOnClickListener(this)
        this.button9.setOnClickListener(this)
        this.buttonClear.setOnClickListener(this)
        this.buttonEq.setOnClickListener(this)
        this.buttonMinus.setOnClickListener(this)
        this.buttonPlus.setOnClickListener(this)
        this.buttonMulti.setOnClickListener(this)
        this.buttonDel.setOnClickListener(this)

        jsEvaluator = JsEvaluator(this)


    }


    override fun onClick(view: View?) {

        var input = when(view?.id) {

            R.id.button0,
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.buttonMinus,
            R.id.buttonPlus,
            R.id.buttonMulti ->

                (view as Button).text

            else ->
            {
                ""
            }
        }

        if( input.isNotEmpty() ) {

            this.textView.text =  this.textView.text as String? + input
        }
        else
        {
            when(view?.id){

                R.id.buttonClear->
                    onClearPress()

                R.id.buttonEq->
                    onClearEq()

                R.id.buttonDel->
                    onDelete()

            }
        }
    }

    fun onDelete() {
        if(this.textView.text.isNotEmpty()){

            if(textView.text.length >1 ){
                this.textView.text = this.textView.text.subSequence(0, this.textView.text.length-1)
            }
            else
            {
                this.textView.text = ""
            }
        }
    }

    fun onClearPress(){
        this.textView.text = ""
    }


    fun onClearEq(){

        jsEvaluator!!.evaluate(textView.text as String, object : JsCallback {
            override fun onResult(result: String) {

                textView.text = result

            }

            override fun onError(errorMessage: String) { // Process JavaScript error here.
                textView.text = "Error"
            }
        })

    }
}
