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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Linking UI elements to variables
        val WelcomeMessage = findViewById<TextView>(R.id.WelcomeMessage)
        val plybutton = findViewById<Button>(R.id.plybutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        //Set welcome message
        WelcomeMessage.text = "Lets play History with Mozambique"

        //Go to the quizz activity when play button is clicked
        plybutton.setOnClickListener {

            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }
        exitbutton.setOnClickListener {     //Exit the app when exit button is clicked
            finishAffinity()
            exitProcess(0)
        }

    }
}