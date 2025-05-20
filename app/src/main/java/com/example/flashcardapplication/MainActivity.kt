package com.example.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val startButton: Button = findViewById(R.id.button)

        startButton.setOnClickListener {
            // Start QuestionActivity
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            }

        }
    }
//  Title: Kotlin Flashcard Application
//  author: Eldies Tshiseke
//  Version: 1.0
//  Available at: