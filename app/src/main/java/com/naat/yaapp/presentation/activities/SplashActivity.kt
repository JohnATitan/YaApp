package com.naat.yaapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.naat.yaapp.R
import com.naat.yaapp.data.internal.sharedpreferences.SessionPreferences

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.statusBarColor = getColor(R.color.main_blue)
    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            var intent: Intent? = null
            if (SessionPreferences.existUser(this)!!) {
                intent = Intent(this, LoginActivity::class.java)
            } else {
                intent = Intent(this, DashboardActivity::class.java)
            }
            startActivity(intent)
            finish()
        }, 2000)
    }
}