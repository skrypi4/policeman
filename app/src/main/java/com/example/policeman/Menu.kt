package com.example.policeman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
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

        val mTranslateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_inviz)

        menuButton1.setOnClickListener {
            menuButton1.startAnimation(mTranslateAnimation)
            menuButton1.visibility = View.INVISIBLE

            val handler1 = Handler().postDelayed(Runnable {
                val intent = Intent(this@Menu, department::class.java)
                startActivity(intent)
            }, 750)

            val handler2 = Handler().postDelayed(Runnable {
                menuButton1.visibility = View.VISIBLE
            }, 1500)
        }

        menuButton2.setOnClickListener {
            menuButton2.startAnimation(mTranslateAnimation)
            menuButton2.visibility = View.INVISIBLE
            val handler1 = Handler().postDelayed(Runnable {
                val intent = Intent(this@Menu, dlyaFramentov::class.java)
                startActivity(intent)
            }, 750)

            val handler2 = Handler().postDelayed(Runnable {
                menuButton2.visibility = View.VISIBLE
            }, 1500)
        }

        menuButton3.setOnClickListener {
            menuButton3.startAnimation(mTranslateAnimation)
            menuButton3.visibility = View.INVISIBLE
            val handler1 = Handler().postDelayed(Runnable {
                val intent = Intent(this@Menu, photoRobot::class.java)
                startActivity(intent)
            }, 750)

            val handler2 = Handler().postDelayed(Runnable {
                menuButton3.visibility = View.VISIBLE
            }, 1500)
        }

        menuButton4.setOnClickListener {
            menuButton4.startAnimation(mTranslateAnimation)
            menuButton4.visibility = View.INVISIBLE
            val handler1 = Handler().postDelayed(Runnable {
                val intent = Intent(this@Menu, Paint::class.java)
                startActivity(intent)
            }, 750)

            val handler2 = Handler().postDelayed(Runnable {
                menuButton4.visibility = View.VISIBLE
            }, 1500)
        }

        menuButton5.setOnClickListener {
            menuButton5.startAnimation(mTranslateAnimation)
            menuButton5.visibility = View.INVISIBLE
            val handler1 = Handler().postDelayed(Runnable {
                val intent = Intent(this@Menu, aboutUs::class.java)
                startActivity(intent)
            }, 750)

            val handler2 = Handler().postDelayed(Runnable {
                menuButton5.visibility = View.VISIBLE
            }, 1500)


        }

    }
}