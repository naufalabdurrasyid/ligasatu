package com.example.ligasatu

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        scheduleSplashScreen()


    }
    private fun scheduleSplashScreen() {
        val splashScreenDuration = getSplashScreenDuration()
        Handler().postDelayed(
            {
                // After the splash screen duration, route to the right activities
                routeToAppropriatePage()

                finish()
            },
            splashScreenDuration
        )
    }
    private fun getSplashScreenDuration() = 2000L

    private fun routeToAppropriatePage() {
        startActivity(
            Intent(this, MainActivity::class.java))
      }
    }

