package com.example.flashcardapplication

import android.annotation.SuppressLint
import android.content.Intent
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
     // Giving to values their assigned identifications
        val score = intent.getIntExtra("score", 0)
        questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        answers = intent.getBooleanArrayExtra("answers")?.toTypedArray() ?: arrayOf()

        val txtScore: TextView = findViewById(R.id.textView3)
        val txtFeedback: TextView = findViewById(R.id.textView4)
        val btnReview: Button = findViewById(R.id.button7)
        val btnExit: Button = findViewById(R.id.button6)
        val results = intent.getStringArrayListExtra("result")
        val feedBack: TextView = findViewById<TextView>(R.id.textView6)
        val btnRestart: Button = findViewById<Button>(R.id.button5)
    // Displaying the Score
        txtScore.text = "You scored $score out of ${questions.size}."

        // Personalized feedback
        txtFeedback.text = when {
            score == questions.size -> "Amazing! You're a history expert!"
            score >= 3 -> "Good job! Just a bit more studying!"
            else -> "Keep practicing! You'll improve!"

        }
        // Seting the review button on click listener to review answers
        btnReview.setOnClickListener {
            feedBack.text = results?.joinToString("\n") ?:"There is no answers yet"


            }


        // Setting the exit button on click listener to exit the application
        btnExit.setOnClickListener {
            finishAffinity()
        }
        // Setting the Restart button on click listener to start over the quiz
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()

        }



        }
    }
//  Title: Kotlin Flashcard Application
//  author: Eldies Tshiseke
//  Version: 1.0
//  Available at: https://www.youtube.com/watch?v=UXGDPHNAL90
