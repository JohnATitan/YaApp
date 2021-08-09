package com.naat.yaapp.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.naat.yaapp.BuildConfig
import com.naat.yaapp.R
import com.naat.yaapp.databinding.ActivityLoginBinding
import com.naat.yaapp.domain.presenters.LoginPresenter
import com.naat.yaapp.presentation.activities.views.LoginView

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var presenter: LoginPresenter

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.secondary_blue)

        initPresenter()
        initListeners()
        initValues()
    }

    private fun initPresenter() {
        presenter = LoginPresenter(this, this)
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener { button ->
            areViewsEnable(false)
            binding.pbLoader.visibility = View.VISIBLE
            presenter.login(binding.etUsername.text.toString(), binding.etPassword.text.toString())
        }
    }

    private fun initValues() {
        binding.tvVersion.text = "V${BuildConfig.VERSION_NAME}"
    }

    override fun loginSucceed() {
        val dashboard = Intent(this, DashboardActivity::class.java)
        startActivity(dashboard)
        finish()
    }

    override fun loginFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        binding.pbLoader.visibility = View.INVISIBLE
        areViewsEnable(true)
    }

    private fun areViewsEnable(enable: Boolean) {
        with(binding) {
            etPassword.isEnabled = enable
            etUsername.isEnabled = enable
            btnLogin.isEnabled = enable
        }
    }
}