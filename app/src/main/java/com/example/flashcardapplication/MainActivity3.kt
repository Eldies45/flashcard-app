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

        val txtScore: TextView = findViewById(R.id.textView3)
        val txtFeedback: TextView = findViewById(R.id.textView4)
        val btnReview: Button = findViewById(R.id.button7)
        val btnExit: Button = findViewById(R.id.button6)

        txtScore.text = "You scored $score out of ${questions.size}."

        // Personalized feedback
        txtFeedback.text = when {
            score == questions.size -> "Amazing! You're a history expert!"
            score >= 3 -> "Good job! Just a bit more studying!"
            else -> "Keep practicing! You'll improve!"

        }

        btnReview.setOnClickListener {


            val theBuilt = StringBuilder()
            for (i in questions.indices) {
                theBuilt.append("${i + 1}. ${questions[i]} \nAnswer: ${if (answers[i]) "True" else "False"}\n\n")
            }


            }




        }
    }
