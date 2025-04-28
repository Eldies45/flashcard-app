package com.example.flashcardapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private val questions = arrayOf(
        "Madame C.G. walker was the first american’s black millionaire.",
        "The French sculptor Frédéric Auguste created the statue of liberty.",
        "The Berlin Wall fell in 1975.",
        "Julius Caesar was a Roman emperor.",
        "The Titanic sank in 1912."
    )

    private val answers = arrayOf(true, true, false, false, true)

    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        }
    }
