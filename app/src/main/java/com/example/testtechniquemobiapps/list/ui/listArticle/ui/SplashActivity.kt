package com.example.testtechniquemobiapps.list.ui.listArticle.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.testtechniquemobiapps.R

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed(Runnable {
            val intent = Intent(this, ListArticle::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)

    }
}