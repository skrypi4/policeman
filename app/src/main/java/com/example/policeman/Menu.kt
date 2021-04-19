package com.example.policeman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.Navigation

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuButton1 = findViewById<Button>(R.id.button)
        val menuButton2 = findViewById<Button>(R.id.button2)
        val menuButton3 = findViewById<Button>(R.id.button3)
        val menuButton4 = findViewById<Button>(R.id.button4)
        val menuButton5 = findViewById<Button>(R.id.button5)

        menuButton5.setOnClickListener {
            val intent = Intent(this@Menu, aboutUs::class.java)
            startActivity(intent)
        }

        menuButton2.setOnClickListener {
            val intent = Intent(this@Menu, dlyaFramentov::class.java)
            startActivity(intent)
        }

            menuButton1.setOnClickListener {
                val intent = Intent(this@Menu, department::class.java)
                startActivity(intent)
        }

        menuButton3.setOnClickListener {
            val intent = Intent(this@Menu, photoRobot::class.java)
            startActivity(intent)
        }

        menuButton4.setOnClickListener {
            val intent = Intent(this@Menu, Paint::class.java)
            startActivity(intent)
        }
    }
}