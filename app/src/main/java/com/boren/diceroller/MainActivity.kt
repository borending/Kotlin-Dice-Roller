package com.boren.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { addCount() }
    }

    private fun rollDice() {
        val rollText: TextView = findViewById(R.id.roll_text)
        rollText.text = (1..6).random().toString()
    }

    private fun addCount() {
        val rollText: TextView = findViewById(R.id.roll_text)
        val text = rollText.text.toString()
        if (text == "1" || text == "2" || text == "3" || text == "4" || text == "5")
            rollText.text = (text.toInt() + 1).toString()
        else {
            var message: String
            if (text == "Hello World!")
                message = "請先擲骰子才能+1"
            else if (text == "6")
                message = "已經是六了，無法+1數字不合法，無法+1"
            else
                message = "數字不合法，無法+1"

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}