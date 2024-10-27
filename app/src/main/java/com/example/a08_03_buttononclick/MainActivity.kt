package com.example.a08_03_buttononclick

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var getText: TextView
    private lateinit var countChars: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        getText = findViewById(R.id.getText)
        countChars = findViewById(R.id.countChars)
        onButtonClick(button)
    }

    fun onButtonClick (view: View) {
        getText.text = editText.text.reversed()

        var count = 0
        for (c in editText.text) {
            if (c != ' ') {
                count++
            }
        }
        countChars.text = count.toString()
    }
}