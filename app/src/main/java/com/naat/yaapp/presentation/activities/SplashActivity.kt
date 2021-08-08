package com.naat.yaapp.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.gson.JsonObject
import com.naat.yaapp.R
import com.titan.test.external.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.statusBarColor = getColor(R.color.main_blue)

//        val call = Service.endpoints.oAuthToken("password", "testnaat@na-at.com.mx", hashString("56Forj2018.", "SHA-256"))
//
//        call.enqueue(object : Callback<JsonObject> {
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                println(response.body().toString())
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//            }
//        })
    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            val login = Intent(this, LoginActivity::class.java)
            startActivity(login)
            finish()
        }, 5000)
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}