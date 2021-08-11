package com.naat.yaapp.presentation.activities.views

import com.naat.yaapp.data.models.Recharge

interface BuyRechargeView {
    fun showRecharge(recharge: Recharge)
    fun showErrorNumber()
    fun showConfirmDialog()
}