package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evgenii.jsevaluator.JsEvaluator

class CalculatorActivity : AppCompatActivity() {

    var jsEvaluator : JsEvaluator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }
}
