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

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoretextView = findViewById<TextView>(R.id.scoretextView)
        val feedbacktextView = findViewById<TextView>(R.id.feedbacktextView)
        val reviewbutton = findViewById<Button>(R.id.reviewbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        val score = intent.getIntExtra("score", 0)
        scoretextView.text = "Your score: $score/8"

        val feedback = if (score >= 3){
            "Wow great job!"
        } else{
            "Oopsie dont worry keep practicing!"
        }
        feedbacktextView.text = feedback

        reviewbutton.setOnClickListener {

            val intent = Intent(this, ReviewPlayerScore ::class.java)
            intent.putExtra("questions", Quiz.questions)
            intent.putExtra("answers", Quiz.answers)
            startActivity(intent)
        }
        exitbutton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
}