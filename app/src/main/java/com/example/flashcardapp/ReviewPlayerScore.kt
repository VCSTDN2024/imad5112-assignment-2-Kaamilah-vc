package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class ReviewPlayerScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_player_score)

        //Linking UI elements
        val reviewscoretextView= findViewById<TextView>(R.id.reviewscoretextView)
        val restartbutton = findViewById<Button>(R.id.restartbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        //Retrieve questions and answers from intent
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        //Format and display review text
        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]} \n")
                reviewText.append("   Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewscoretextView.text = reviewText.toString()
        } else {
            reviewscoretextView.text = "Failed to retrieve review data"
        }

        //Restart the quiz
        restartbutton.setOnClickListener {
            startActivity(Intent(this, Quiz::class.java))
        }
        //Exit the app
        exitbutton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}
