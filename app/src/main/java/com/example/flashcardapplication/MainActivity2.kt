package com.example.flashcardapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        val txtQuestion: TextView = findViewById(R.id.textView2)
        val btnTrue: Button = findViewById(R.id.button2)
        val btnFalse: Button = findViewById(R.id.button3)
        val btnNext: Button = findViewById(R.id.button4)

        questionLoading()
        btnTrue.setOnClickListener {
            answerChecking(true)

        }

        btnFalse.setOnClickListener {
            answerChecking(false)

        }

        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                questionLoading()

            } else {
                // Finished all questions, go to ScoreActivity
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }

        }
    }

    private fun MainActivity2.questionLoading() {
        txtQuestion.text = questions[currentQuestionIndex]
        btnTrue.isEnabled = true
        btnFalse.isEnabled = true
    }
    private fun answerChecking(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }
        // Disable the buttons after the attempt to avoid cheating
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
    }
}