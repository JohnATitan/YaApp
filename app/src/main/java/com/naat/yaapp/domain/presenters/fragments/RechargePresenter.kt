package com.naat.yaapp.domain.presenters.fragments

import com.naat.yaapp.data.external.configuration.ServiceListener
import com.naat.yaapp.data.external.services.GetRechargesService
import com.naat.yaapp.data.models.Recharge

class RechargePresenter {

    fun getRecharges() {
        val listener = object : ServiceListener<Array<Recharge>, Boolean> {
            override fun onServiceSucceed(array: Array<Recharge>) {
                array.size
            }

            override fun onServiceFail(k: Boolean) {
            }
        }
        GetRechargesService(listener).callService()
    }

}