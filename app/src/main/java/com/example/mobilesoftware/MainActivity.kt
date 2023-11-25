package com.example.mobilesoftware

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val bottomTextView = findViewById<TextView>(R.id.bottomTextView)

        button1.setOnClickListener {
            bottomTextView.text = "복숭아 1개 5000원을 장바구니에 담았습니다."
        }

        button2.setOnClickListener {
            Toast.makeText(this@MainActivity, "결제 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }
}