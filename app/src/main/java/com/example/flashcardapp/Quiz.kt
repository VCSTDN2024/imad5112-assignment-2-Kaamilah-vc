package com.example.flashcardapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {
    //Declaring UI components
    private lateinit var questiontextView: TextView
    private lateinit var truebutton: Button
    private lateinit var falsebutton: Button
    private lateinit var nextbutton: Button
    private lateinit var feedbacktextView: TextView

    // Companion object to hold questions, answers, and score
    companion object {
        val questions = arrayOf(
            "Mozambique gained independence from Britain in 1975",
            "FRELIMO was the movement that led the fight for Mozambique’s independence",
            "Maputo is the capital city of Mozambique",
            "Samora Machel was the first president of independent Mozambique",
            "RENAMO was the ruling party after independence",
            "The Mozambican Civil War ended in 1992"
        )
        val answers = booleanArrayOf(false, true, true, true, false, true)

        private var currentQuestionIndex = 0
        private var score = 0

    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_quiz)
        //Linking UI components
            questiontextView= findViewById(R.id.questiontextView)
            truebutton= findViewById(R.id.truebutton)
            falsebutton= findViewById(R.id.falsebutton)
            nextbutton= findViewById(R.id.nextbutton)
            feedbacktextView= findViewById(R.id.feedbacktextView)

            displayQuestion()       //Show the first question
        //Set click listeners for answer buttons
            truebutton.setOnClickListener { checkAnswer(true) }
            falsebutton.setOnClickListener { checkAnswer(false) }

            // Set click listener for the next button
            nextbutton.setOnClickListener {
                currentQuestionIndex ++
                if (currentQuestionIndex < questions.size){
                    displayQuestion()
                    feedbacktextView.text = ""
                    truebutton.isEnabled = true
                    falsebutton.isEnabled = true
                } else  {
                    //Navigate to score activity
                    val intent = Intent(this, Score::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
            //Disable next button until an answer is select
            nextbutton.isEnabled = false
        }
    private fun displayQuestion(){
        questiontextView.text = questions[currentQuestionIndex]

    }
    //Checking the user's answer and show feedback
    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer){
            feedbacktextView.text = "Correct"
            feedbacktextView.setTextColor(Color.GREEN)
            score ++
        } else {
            feedbacktextView.text = "Incorrect"
            feedbacktextView.setTextColor(Color.RED)
        }
        //Disable answer buttons and enable next
        truebutton.isEnabled = false
        falsebutton.isEnabled = false
        nextbutton.isEnabled = true
        }
    }

