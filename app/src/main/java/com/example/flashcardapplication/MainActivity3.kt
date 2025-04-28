package com.example.flashcardapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var questions: Array<String>
    private lateinit var answers: Array<Boolean>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val score = intent.getIntExtra("score", 0)
        questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        answers = intent.getBooleanArrayExtra("answers")?.toTypedArray() ?: arrayOf()

        val scoreText: TextView = findViewById(R.id.textView3)
        val feedbackText: TextView = findViewById(R.id.textView4)
        val reviewButton: Button = findViewById(R.id.button5)
        val exitButton: Button = findViewById(R.id.button6)




    }
}