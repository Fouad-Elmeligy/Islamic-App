package com.example.islamiapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screan)
        Handler(Looper.getMainLooper()).postDelayed(object :Runnable{
            override fun run() {
                navigaionToHomeScreen()
            }

        },2000)

        }
    fun navigaionToHomeScreen(){
        val intent=Intent(this,HomeScreenActivity::class.java)
        startActivity(intent)
        finish()
    }
    }
