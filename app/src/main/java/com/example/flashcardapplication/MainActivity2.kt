package com.example.flashcardapplication

import android.annotation.SuppressLint
import android.app.admin.TargetUser
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

    private val answers = booleanArrayOf(true, true, false, false, true)
    private val userResults = mutableListOf<String>()
    private var ansWered = false

    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var appResponce: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        txtQuestion = findViewById(R.id.textView2)
        btnTrue = findViewById(R.id.button2)
        btnFalse = findViewById(R.id.button3)
        btnNext = findViewById(R.id.button4)
        appResponce = findViewById(R.id.textView7)



        btnNext.isEnabled = false
        txtQuestion.text=questions[currentQuestionIndex]
        btnTrue.setOnClickListener {
            anscheck(true)
            ansWered = true
            appResponce.text = "True"
        btnTrue.isEnabled = false
            btnFalse.isEnabled = false
            btnNext.isEnabled = true
        }

        btnFalse.setOnClickListener {
            anscheck(false)
            ansWered = true
            appResponce.text = "False"
        btnFalse.isEnabled = false
            btnTrue.isEnabled = false
            btnNext.isEnabled = true
        }

        btnNext.setOnClickListener {
            btnNext.isEnabled = false
           btnFalse.isEnabled = true
            btnTrue.isEnabled = true
            if (currentQuestionIndex+1 < questions.size) {


                currentQuestionIndex++
                updateQuestion()

            } else {
                // Finished all questions, go to ScoreActivity
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                intent.putStringArrayListExtra("result", ArrayList(userResults))
                startActivity(intent)
            }
        }


    }

    private fun updateQuestion() {
        txtQuestion.text = questions[currentQuestionIndex]


    }
    private fun anscheck (userAns: Boolean) {
        val correctAns = answers[currentQuestionIndex]
        val txtResult =
            if ( userAns==correctAns) {
            score++
            "Q${currentQuestionIndex +1 } Correct"
        } else{
                "Q${currentQuestionIndex +1 }: Incorrect"
            }
        userResults.add(txtResult)
    }
    fun main() {
        for (i in questions.indices) {
        println("Q: ${questions[i]}")
        println("answer: ${answers[i]}")
    }

    }



}

