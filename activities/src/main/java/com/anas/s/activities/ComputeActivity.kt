package com.anas.s.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var calcul: Button
    private lateinit var text: TextView
    private lateinit var text1: EditText
    private lateinit var text2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        calcul = findViewById(R.id.btn_calculer)
        text = findViewById(R.id.resultat)
        text1 = findViewById(R.id.field_1)
        text2 = findViewById(R.id.field_2)
        calcul.isEnabled = false
        text1.addTextChangedListener(this)
        text2.addTextChangedListener(this)
        calcul.setOnClickListener {
            text.text = (text1.text.toString().toDouble() + text2.text.toString().toDouble()).toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        calcul.isEnabled = text1.text.isNotEmpty() && text2.text.isNotEmpty()
    }
}
