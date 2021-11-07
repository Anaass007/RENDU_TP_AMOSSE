package com.anas.s.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private lateinit var text: TextView
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (nbClick == 0) {
            text.text = ""
        }
        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        text = findViewById(R.id.text)
        clickButton.setOnClickListener {
            nbClick++
            val newText = "Cliquez moi $nbClick"
            clickButton.text = newText
            val newTexts = "Vous avez cliquez $nbClick fois"
            text.text = newTexts

            if (nbClick == 6) {
                clickButton.isEnabled = false
            }
        }
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}
