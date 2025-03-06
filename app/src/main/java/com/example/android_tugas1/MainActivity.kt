package com.example.android_tugas1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun handleClick(view: View){
        val inputText = findViewById<EditText>(R.id.inputText)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val text = inputText.text.toString().trim()
        val wordCount = if (text.isEmpty()) 0 else text.split("\\s+".toRegex()).size

        tvResult.text = "Jumlah : $wordCount Kata"
    }
}