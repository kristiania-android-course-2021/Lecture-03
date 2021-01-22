package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.evgenii.jsevaluator.JsEvaluator
import com.evgenii.jsevaluator.interfaces.JsCallback


class CalculatorActivity : AppCompatActivity() {

    //Todo Question: what is the significance of  "lateinit"?
    lateinit var jsEvaluator : JsEvaluator
    lateinit var textViewExpression: TextView

    var buttonEq: Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        buttonEq = findViewById<Button>(R.id.buttonEq)
        textViewExpression = findViewById<Button>(R.id.textView)

        //Todo: Find out how this project is including thirdparty opensource library JsEvaluator into the project
        //Todo: Vist lib page: https://github.com/evgenyneu/js-evaluator-for-android to get more help about library
        jsEvaluator = JsEvaluator(this)

        //Handling of click event for buttonEq
        buttonEq?.setOnClickListener {
            evaluate()
        }
    }

    private fun evaluate () {

        if( textViewExpression.text.isNotBlank() ) {
            //Todo note result is coming back in the callback interface
            jsEvaluator.evaluate(textViewExpression.text as String, object : JsCallback {
                override fun onResult(result: String) {
                    textViewExpression.text =  result
                }

                override fun onError(errorMessage: String) {
                    textViewExpression.text =  errorMessage
                }
            })
        }
    }
}
