package com.naat.yaapp.domain.presenters

import com.naat.yaapp.data.internal.bd.configuration.DBInstance
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.presentation.activities.views.BuyRechargeView

class BuyRechargePresenter(val idRecharge: Long, val view: BuyRechargeView) {

    val recharge: Recharge by lazy {
        DBInstance.getDao().selectRecharge(idRecharge)
    }

    fun getRecharge(){
        view.showRecharge(recharge)
    }

}