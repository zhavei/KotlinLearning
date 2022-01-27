package com.example.kotlinlearning

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hidetoolbar()

        val rollButton: Button = findViewById(R.id.Mbutton)
        val intentBut: Button = findViewById(R.id.buttonToIntent)
        intentBut.setOnClickListener {
            val intent = Intent (this, CalculatorTips::class.java)
            startActivity(intent)
        }
        rollButton.setOnClickListener {
            rollDice()
            Log.d(TAG, "just make sure its rollerd")
            Toast.makeText(this, "diceRoll", Toast.LENGTH_SHORT).show() }

        rollDice()
        Log.v(TAG, "testing rolling dice")
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView1)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
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