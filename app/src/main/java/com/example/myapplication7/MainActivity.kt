package com.example.myapplication7

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activity1 = findViewById<ConstraintLayout>(R.id.activity1)
        var click = findViewById<Button>(R.id.click)
        val longText = findViewById<TextView>(R.id.longText)

        click.setOnClickListener {
            Toast.makeText(this, "Button click ", Toast.LENGTH_SHORT).show()
            longText.text = "Simple Click On Button "
        }

        click.setOnLongClickListener {
            Toast.makeText(this@MainActivity,"Button Long click",Toast.LENGTH_SHORT).show()
            longText.text = "Long Click On Button"
            true
        }



        activity1.setOnTouchListener(object :OnSwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft(): Boolean {
                val i = Intent(this@MainActivity, MainActivity2::class.java )
                startActivity(i)
                return true;
            }
        })

    }}