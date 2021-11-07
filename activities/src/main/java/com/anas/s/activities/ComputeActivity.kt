package com.anas.s.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity() {
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
    }
}
