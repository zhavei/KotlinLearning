package com.example.kotlinlearning

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hidetoolbar()

        val rollButton: Button = findViewById(R.id.Mbutton)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "diceRoll", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.tvText)
        resultTextView.text = diceRoll.toString()
    }

    fun hidetoolbar() {
        if (supportActionBar != null) supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

    }

    class Dice(val numDice: Int) {
        fun roll(): Int {
            return (1..numDice).random()
        }
    }

}