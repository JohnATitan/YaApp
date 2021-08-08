package com.naat.yaapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naat.yaapp.R
import com.naat.yaapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.secondary_blue)
    }
}