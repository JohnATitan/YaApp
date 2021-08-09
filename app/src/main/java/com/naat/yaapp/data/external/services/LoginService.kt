package com.naat.yaapp.data.external.services

import com.google.gson.JsonObject
import com.naat.yaapp.data.external.configuration.ServiceListener
import com.naat.yaapp.domain.utils.UtilSecurity
import com.titan.test.external.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val listener: ServiceListener<Boolean, Boolean>) {

    fun callService(userName: String, password: String) {
        val call = Service.endpoints.oAuthToken("password", userName, UtilSecurity.encript(password))

        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                with(response) {
                    if (body() != null) {
                        listener.onServiceSucceed(true)
                    } else {
                        listener.onServiceFail(true)
                    }
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                listener.onServiceFail(true)
            }
        })
    }
}