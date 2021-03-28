package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewOp = true
    fun buNumberEvent(view: View) {
        if (isNewOp){
            editShowNumber.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buSelectValue:String = editShowNumber.text.toString()
        when(buSelect.id){
            bu0.id -> {
                buSelectValue += "0"
            }
            bu1.id -> {
                buSelectValue += "1"
            }
            bu2.id -> {
                buSelectValue += "2"
            }
            bu3.id -> {
                buSelectValue += "3"
            }
            bu4.id -> {
                buSelectValue += "4"
            }
            bu5.id -> {
                buSelectValue += "5"
            }
            bu6.id -> {
                buSelectValue += "6"
            }
            bu7.id -> {
                buSelectValue += "7"
            }
            bu8.id -> {
                buSelectValue += "8"
            }
            bu9.id -> {
                buSelectValue += "9"
            }
            buDot.id -> {
                buSelectValue += "."
            }
            buPlusMinus.id -> {
                buSelectValue = "-$buSelectValue"
            }

        }
        editShowNumber.setText(buSelectValue)
    }
 var oldNumber=""
  var op ="+"
    fun buOpEvent(view: View) {
        oldNumber=editShowNumber.text.toString()
        isNewOp = true
        val buSelect = view as Button
        when (buSelect.id) {
            buAdd.id -> {
                op = "+"
            }
            buDiv.id -> {
                op = "/"
            }
            buSub.id -> {
                op = "-"
            }
            buMult.id -> {
                op = "*"
            }
        }
    }

    fun buEqualEvent(view: View) {
        val newNumber =editShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "/"->{
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "*"->{
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "+"->{
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
            "-"->{
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        editShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercent(view: View) {
        val number:Double = editShowNumber.text.toString().toDouble() / 100
        editShowNumber.setText(number.toString())
        isNewOp = true
    }

    fun buClean(view: View) {
        editShowNumber.setText("0")
        isNewOp = true
    }

}