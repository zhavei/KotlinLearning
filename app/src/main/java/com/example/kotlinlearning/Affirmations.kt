package com.example.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlinlearning.data.DataSource

class Affirmations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affirmations)

        val textView: TextView = findViewById(R.id.text_afirmation)
        textView.text = DataSource().loadAffirmations().size.toString()
    }
}