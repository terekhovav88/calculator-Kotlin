package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.CleartextNetworkViolation
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener {setText("0")}
        btn_1.setOnClickListener {setText("1")}
        btn_2.setOnClickListener {setText("2")}
        btn_3.setOnClickListener {setText("3")}
        btn_4.setOnClickListener {setText("4")}
        btn_5.setOnClickListener {setText("5")}
        btn_6.setOnClickListener {setText("6")}
        btn_7.setOnClickListener {setText("7")}
        btn_8.setOnClickListener {setText("8")}
        btn_9.setOnClickListener {setText("9")}
        btn_0.setOnClickListener {setText("0")}
        btn_AC.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        btn_dot.setOnClickListener {setText(".")}
        btn_right.setOnClickListener {setText("(")}
        btn_left.setOnClickListener {setText(")")}
        btn_add.setOnClickListener {setText("+")}
        btn_min.setOnClickListener {setText("-")}
        btn_sep.setOnClickListener {setText("/")}
        btn_more.setOnClickListener {setText("*")}
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length - 1)
                result_text.text = ""
            }
        }
        btn_res.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }
            catch (e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setText(str: String) {
        if(result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
}
