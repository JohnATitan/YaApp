package com.naat.yaapp.domain.presenters

import com.naat.yaapp.data.external.configuration.ServiceListener
import com.naat.yaapp.data.external.services.LoginService
import com.naat.yaapp.presentation.activities.views.LoginView

class LoginPresenter(private val view: LoginView) {

    fun login(userName: String, password: String) {
        if (validateFields(userName, password)) {
            val loginService = LoginService(object : ServiceListener<Boolean, Boolean> {
                override fun onServiceSucceed(t: Boolean) {
                    view.loginSucceed()
                }

                override fun onServiceFail(k: Boolean) {
                    view.loginFailed("Ocurrio un error durante el inicio de sesión")
                }
            })
            loginService.callService(userName, password)
        }
    }


    private fun validateFields(userName: String, password: String): Boolean {
        if (userName.trim().isEmpty() || password.trim().isEmpty()) {
            view.loginFailed("Los campos son incorrectos")
            return false
        }
        return true
    }

}