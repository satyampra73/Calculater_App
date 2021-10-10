package com.satyam.mycalculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var zero:TextView
    lateinit var ac:TextView
    lateinit var modulo:TextView
    lateinit var decimal:TextView
    lateinit var equal:TextView
    lateinit var minus:TextView
    lateinit var expression:TextView
    lateinit var result:TextView
    lateinit var plus:TextView
    lateinit var multiply:TextView
    lateinit var devide:TextView
    lateinit var backspace:ImageView
    lateinit var changesign:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one =findViewById(R.id.one)
        two =findViewById(R.id.two)
        three =findViewById(R.id.three)
        four =findViewById(R.id.four)
        five =findViewById(R.id.five)
        six =findViewById(R.id.six)
        seven =findViewById(R.id.seven)
        eight =findViewById(R.id.eight)
        nine =findViewById(R.id.nine)
        zero =findViewById(R.id.zero)
        plus =findViewById(R.id.plus)
        expression =findViewById(R.id.expression)
        result =findViewById(R.id.result)
        minus=findViewById(R.id.minus)
        ac =findViewById(R.id.ac)
        modulo=findViewById(R.id.modulo)
        decimal =findViewById(R.id.decimal)
        multiply=findViewById(R.id.multiply)
        backspace=findViewById(R.id.backspace)
        devide=findViewById(R.id.devide)
        changesign =findViewById(R.id.changesign)
        equal =findViewById(R.id.equal)

        one.setOnClickListener {
            appendText("1",true)
        }
        two.setOnClickListener {
            appendText("2",true)
        }
        three.setOnClickListener {
            appendText("3",true)
        }
        four.setOnClickListener {
            appendText("4",true)
        }
        five.setOnClickListener {
            appendText("5",true)
        }
        six.setOnClickListener {
            appendText("6",true)
        }
        seven.setOnClickListener {
            appendText("7",true)
        }
        eight.setOnClickListener {
            appendText("8",true)
        }
        nine.setOnClickListener {
            appendText("9",true)
        }
        zero.setOnClickListener {
            appendText("0",true)
        }
        plus.setOnClickListener {
            appendText("+",false)
        }
        minus.setOnClickListener {
            appendText("-",false)
        }
        multiply.setOnClickListener {
            appendText("*",false)
        }
        devide.setOnClickListener {
            appendText("/",false)
        }
        modulo.setOnClickListener {
            appendText("%",true)
        }
        equal.setOnClickListener {
            try {
                val expr =ExpressionBuilder(expression.text.toString()).build()
                val answer =expr.evaluate()
                result.text=answer.toString()
            }
            catch (exception:Exception){
                result.text=exception.message
            }
        }
        decimal.setOnClickListener {
            appendText(".",true)
        }
        changesign.setOnClickListener {
            result.text =""
            result.hint =""
            if(expression.text.isNotEmpty()&& expression.text[0]=='-'){
                expression.text=expression.text.substring(1)

            }
            else{
                expression.text="-${expression.text}"
            }
        }
        backspace.setOnClickListener {
            result.text=""
            result.text=""
            if(expression.text.isNotEmpty()){
                expression.text =expression.text.substring(0,expression.text.length-1)
            }
        }

        ac.setOnClickListener {
            expression.text=""
            result.text=""
            result.hint =""
        }
    }
    private fun appendText(value:String,toBeCleared:Boolean){
        if(result.text!=""){
            expression.text!=""
        }
        if(toBeCleared){
            result.text =""
            expression.append(value)
        }else{
            expression.append(result.text)
            expression.append(value)
            result.text=""
        }
        result.hint=expression.hint

    }
}