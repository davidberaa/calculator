package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(view: View) {
        if(view is TextView) {
            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if(result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }
    }

    fun operationClick(view: View) {
        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }
            this.operation = view.text.toString()
            resultTextView.text = ""
        }
    }

    fun equalsClick(view: View) {
        val secOperandText: String = resultTextView.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        when(operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "—" -> resultTextView.text = (operand - secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()
            "x" -> resultTextView.text = (operand * secOperand).toString()
        }
    }
}