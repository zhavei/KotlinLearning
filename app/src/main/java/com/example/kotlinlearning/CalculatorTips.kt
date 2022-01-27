package com.example.kotlinlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlearning.databinding.ActivityCalculatorTipsBinding
import java.text.NumberFormat

class CalculatorTips : AppCompatActivity() {

    lateinit var binding: ActivityCalculatorTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mButtonTwo.setOnClickListener { calculateTip() }


    }

    fun calculateTip() {
        val stringTextField = binding.costOfService.text.toString()
        val cost = stringTextField.toDouble()
        val selectedId = binding.tipOptiion.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighty_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundSwicth.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formatedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formatedTip)
    }

}