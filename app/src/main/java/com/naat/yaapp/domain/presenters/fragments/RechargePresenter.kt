package com.naat.yaapp.domain.presenters.fragments

import com.naat.yaapp.data.external.configuration.ServiceListener
import com.naat.yaapp.data.external.services.GetRechargesService
import com.naat.yaapp.data.internal.bd.configuration.DBInstance
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.presentation.fragments.views.RechargeView

class RechargePresenter(val view: RechargeView) {

    fun getRecharges() {
        val recharges = DBInstance.getDao().selectRecharges()
        if (recharges.isNotEmpty()) {
            buildRechargeArray(recharges)
        } else {
            downloadRecharges()
        }
    }

    private fun downloadRecharges() {
        val listener = object : ServiceListener<Array<Recharge>, Boolean> {
            override fun onServiceSucceed(array: Array<Recharge>) {
                DBInstance.getDao().insertRecharges(array)
                buildRechargeArray(array)
            }

            override fun onServiceFail(k: Boolean) {
            }
        }
        GetRechargesService(listener).callService()
    }

    private fun buildRechargeArray(recharges: Array<Recharge>){
        val array = arrayOf(
            recharges.filter { it.companyName.equals("Claro") },
            recharges.filter { it.companyName.equals("Entel") },
            recharges.filter { it.companyName.equals("Tuenti") }
        )
        view.showRecharges(array)
    }

}