package com.example.kotlinlearning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlearning.databinding.ActivityCalculatorTipsBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat

class CalculatorTips : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mButtonTwo.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {
        val stringTextField = binding.costOfService.text.toString()

        val cost = stringTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            Snackbar.make(binding.root, "Please Fill the Cost Service", Snackbar.LENGTH_SHORT).show()
            displayTip(0.0)
            return
        }

        val tipPercentage = when (binding.tipOptiion.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighty_percent -> 0.18
            else -> 0.15
        }
        var tipingFee = tipPercentage * cost

        if (binding.roundSwicth.isChecked) {
            tipingFee = kotlin.math.ceil(tipingFee)
        }

        displayTip(tipingFee)
    }

    private fun displayTip(tipMoney: Double) {
        val formatedTip = NumberFormat.getCurrencyInstance().format(tipMoney)
        binding.tipResult.text = getString(R.string.tip_amount, formatedTip)
    }

}