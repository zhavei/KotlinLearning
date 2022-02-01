package com.example.kotlinlearning

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handlekeyEvent(view, keyCode) }
    }

    private fun calculateTip() {
        val stringTextField = binding.costOfServiceEditText.text.toString()

        val cost = stringTextField.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            Snackbar.make(binding.root, "Please Fill the Cost Service", Snackbar.LENGTH_SHORT)
                .show()
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

    private fun handlekeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }

}