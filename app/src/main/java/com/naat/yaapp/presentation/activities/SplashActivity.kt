package com.naat.yaapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.JsonObject
import com.naat.yaapp.R
import com.titan.test.external.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = Service.endpoints.oAuthToken("password", "testnaat@na-at.com.mx", hashString("56Forj2018.", "SHA-256"))

        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                println(response.body().toString())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
            }
        })
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}